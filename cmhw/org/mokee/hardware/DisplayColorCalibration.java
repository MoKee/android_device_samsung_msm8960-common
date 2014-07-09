/*
 * Copyright (C) 2014 The MoKee OpenSource Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.mokee.hardware;

import org.mokee.hardware.util.FileUtils;

import java.io.File;

public class DisplayColorCalibration {
    private static final String COLOR_FILE = "/sys/class/misc/gammacontrol/tuner";

    public static boolean isSupported() {
        File f = new File(COLOR_FILE);

        if(f.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public static int getMaxValue()  {
        return 120;
    }

    public static int getMinValue()  {
        return 0;
    }

    public static int getDefValue() {
        return 60;
    }

    public static String getCurColors()  {
        return FileUtils.readOneLine(COLOR_FILE);
    }

    public static boolean setColors(String colors) {
        return FileUtils.writeLine(COLOR_FILE, colors);
    }
}

