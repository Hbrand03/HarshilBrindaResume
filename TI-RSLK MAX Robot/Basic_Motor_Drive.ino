#include "Romi_Motor_Power.h"
/* Defines pin configuration of robot */
#include "RSLK_Pins.h"
#include "SimpleRSLK.h"

int left_speed = 15;
int right_speed = 15;

//setup function
void setup(){
  setupRSLK();
  
  //set motor directions
  setMotorDirection(BOTH_MOTORS, MOTOR_DIR_FORWARD);
  //turn motors ON
  enableMotor(BOTH_MOTORS);
  //give the motors an initial speed
  setMotorSpeed(RIGHT_MOTOR, right_speed);
  setMotorSpeed(LEFT_MOTOR, left_speed);
  
  delay(5000);
  
  setMotorSpeed(BOTH_MOTORS,0);
  disableMotor(BOTH_MOTORS);
}

void loop(){
  
}
