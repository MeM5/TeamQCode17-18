/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.*;

import static com.sun.tools.javac.main.Option.S;

/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@Autonomous(name="Matthew Modi: @MeM5 (reddit/github), @mmmmmmmodi (instagram/snapchat) Autonomous")
public class Autonomous_Main extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
//    private DcMotor FL = null;
//    private DcMotor FR = null;
//    private DcMotor RL = null;
//    private DcMotor RR = null;
    private DcMotor L = null;

    @Override
    public void runOpMode() {
        //Initialize Telemetry
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        //Motor Initialzation
//        FL = hardwareMap.get(DcMotor.class, "FL Drive");
//        FR = hardwareMap.get(DcMotor.class, "FR Drive");
//        RL = hardwareMap.get(DcMotor.class, "BL Drive");
//        RR = hardwareMap.get(DcMotor.class, "BR Drive");
        L = hardwareMap.get(DcMotor.class, "Riser Lift");

        //Motor Directions
//        FL.setDirection(DcMotorSimple.Direction.REVERSE);
//        RL.setDirection(DcMotorSimple.Direction.REVERSE);
        L.setDirection(DcMotorSimple.Direction.FORWARD);

        //Set Motor Mode
        L.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        L.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //Wait For Play, Reset Timer
        waitForStart();
        runtime.reset();

        int i = L.getCurrentPosition();
        L.setPower(1.0);

        //Run until stop
        while(opModeIsActive()){
            if(i > -1700){
                i--;
            }else if (i == 1700){
                break;
            }
            L.setTargetPosition(i);
            telemetry.addData("Encoder: ", i);
            telemetry.update();
        }
    }
}
