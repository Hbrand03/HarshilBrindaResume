#include "Romi_Motor_Power.h"
/* Defines pin configuration of robot */
#include "RSLK_Pins.h"
#include "SimpleRSLK.h"

int left_speed = 16;
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

  //initialize bump sensor inputs
  pinMode(BP_SW_PIN_0,INPUT_PULLUP);
  pinMode(BP_SW_PIN_1,INPUT_PULLUP);
  pinMode(BP_SW_PIN_2,INPUT_PULLUP);
  pinMode(BP_SW_PIN_3,INPUT_PULLUP);
  pinMode(BP_SW_PIN_4,INPUT_PULLUP);
  pinMode(BP_SW_PIN_5,INPUT_PULLUP);

}

void loop(){
  
  bool pressed = false;
  if(digitalRead(BP_SW_PIN_0) == 0){
    pressed = true;
  }
  if(digitalRead(BP_SW_PIN_1) == 0){
    pressed = true;
  }
  if(digitalRead(BP_SW_PIN_2) == 0){
    pressed = true;
  }
  if(digitalRead(BP_SW_PIN_3) == 0){
    pressed = true;
  }
  if(digitalRead(BP_SW_PIN_4) == 0){
    pressed = true;
  }
  if(digitalRead(BP_SW_PIN_5) == 0){
    pressed = true;
  }

if(pressed == true){
  setMotorDirection(RIGHT_MOTOR, MOTOR_DIR_BACKWARD);
  setMotorDirection(LEFT_MOTOR, MOTOR_DIR_BACKWARD);
  setMotorSpeed(RIGHT_MOTOR, right_speed);
  setMotorSpeed(LEFT_MOTOR, left_speed);
  
  delay(1000);
  setMotorDirection(RIGHT_MOTOR, MOTOR_DIR_BACKWARD);
  setMotorDirection(LEFT_MOTOR, MOTOR_DIR_FORWARD);

  delay(2000);

  setMotorDirection(RIGHT_MOTOR, MOTOR_DIR_FORWARD);
  setMotorDirection(LEFT_MOTOR, MOTOR_DIR_FORWARD);
  setMotorSpeed(BOTH_MOTORS, left_speed);
  pressed == false;
  }
}
