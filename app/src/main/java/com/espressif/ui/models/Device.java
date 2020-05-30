// Copyright 2020 Espressif Systems (Shanghai) PTE LTD
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.espressif.ui.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Device implements Parcelable {

    private String nodeId;
    private String deviceName;
    private String deviceType;
    private String primaryParamName;
    private ArrayList<Param> params;

    public Device(String id) {
        nodeId = id;
    }

    public String getNodeId() {
        return nodeId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getPrimaryParamName() {
        return primaryParamName;
    }

    public void setPrimaryParamName(String primaryParamName) {
        this.primaryParamName = primaryParamName;
    }

    public ArrayList<Param> getParams() {
        return params;
    }

    public void setParams(ArrayList<Param> params) {
        this.params = params;
    }

    protected Device(Parcel in) {

        nodeId = in.readString();
        deviceName = in.readString();
        deviceType = in.readString();
        primaryParamName = in.readString();
        params = in.createTypedArrayList(Param.CREATOR);
    }

    public static final Creator<Device> CREATOR = new Creator<Device>() {
        @Override
        public Device createFromParcel(Parcel in) {
            return new Device(in);
        }

        @Override
        public Device[] newArray(int size) {
            return new Device[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(nodeId);
        dest.writeString(deviceName);
        dest.writeString(deviceType);
        dest.writeString(primaryParamName);
        dest.writeTypedList(params);
    }

    @Override
    public String toString() {
        return "EspDevice {" +
                "node id = '" + nodeId + '\'' +
                "name = '" + deviceName + '\'' +
                ", type ='" + deviceType + '\'' +
                '}';
    }
}