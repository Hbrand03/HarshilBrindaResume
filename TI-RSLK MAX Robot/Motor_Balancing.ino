#include "Romi_Motor_Power.h"
/* Defines pin configuration of robot */
#include "RSLK_Pins.h"
#include "SimpleRSLK.h"

float targetSpeed = 15;
float kp = 0.1;

//setup function
void setup(){
  setupRSLK();

  /* Serial init function for debugging purposes */
  Serial.begin(9600);
  
  //set motor directions
  setMotorDirection(BOTH_MOTORS, MOTOR_DIR_FORWARD);
  //turn motors ON
  enableMotor(BOTH_MOTORS);

  // Set the encoder pulses count back to zero
  resetLeftEncoderCnt();
  resetRightEncoderCnt();
  
  //give the motors an initial speed
  setMotorSpeed(RIGHT_MOTOR, targetSpeed);
  setMotorSpeed(LEFT_MOTOR, targetSpeed);
}

void loop(){
  float leftCount = getEncoderLeftCnt();
  float rightCount = getEncoderRightCnt();

  float leftError = rightCount - leftCount;
  float rightError = leftCount - rightCount;

  int leftSpeed = targetSpeed + leftError * kp;
  int rightSpeed = targetSpeed + rightError * kp;

  /* Debugging print outs */
  Serial.print("Left Count: ");
  Serial.println(leftCount);
  Serial.print("Right Count: ");
  Serial.println(rightCount);
  Serial.print("Left Error: ");
  Serial.println(leftError);
  Serial.print("Right Error: ");
  Serial.println(rightError);

  setMotorSpeed(RIGHT_MOTOR, rightSpeed);
  setMotorSpeed(LEFT_MOTOR, leftSpeed);
}