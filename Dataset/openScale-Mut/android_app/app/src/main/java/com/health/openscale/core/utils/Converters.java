/* Copyright (C) 2018  olie.xdev <olie.xdev@googlemail.com>
*
*    This program is free software: you can redistribute it and/or modify
*    it under the terms of the GNU General Public License as published by
*    the Free Software Foundation, either version 3 of the License, or
*    (at your option) any later version.
*
*    This program is distributed in the hope that it will be useful,
*    but WITHOUT ANY WARRANTY; without even the implied warranty of
*    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*    GNU General Public License for more details.
*
*    You should have received a copy of the GNU General Public License
*    along with this program.  If not, see <http://www.gnu.org/licenses/>
*/
package com.health.openscale.core.utils;

import androidx.room.TypeConverter;
import java.util.Date;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

public class Converters {

    public enum MeasureUnit {

        CM, INCH;

        public String toString() {
            if (!ListenerUtil.mutListener.listen(5515)) {
                switch(this) {
                    case CM:
                        return "cm";
                    case INCH:
                        return "in";
                }
            }
            return "";
        }

        public static MeasureUnit fromInt(int unit) {
            if (!ListenerUtil.mutListener.listen(5516)) {
                switch(unit) {
                    case 0:
                        return CM;
                    case 1:
                        return INCH;
                }
            }
            return CM;
        }

        public int toInt() {
            if (!ListenerUtil.mutListener.listen(5517)) {
                switch(this) {
                    case CM:
                        return 0;
                    case INCH:
                        return 1;
                }
            }
            return 0;
        }
    }

    public enum WeightUnit {

        KG, LB, ST;

        public String toString() {
            if (!ListenerUtil.mutListener.listen(5518)) {
                switch(this) {
                    case LB:
                        return "lb";
                    case ST:
                        return "st";
                }
            }
            return "kg";
        }

        public static WeightUnit fromInt(int unit) {
            if (!ListenerUtil.mutListener.listen(5519)) {
                switch(unit) {
                    case 1:
                        return LB;
                    case 2:
                        return ST;
                }
            }
            return KG;
        }

        public int toInt() {
            if (!ListenerUtil.mutListener.listen(5520)) {
                switch(this) {
                    case LB:
                        return 1;
                    case ST:
                        return 2;
                }
            }
            return 0;
        }
    }

    public enum Gender {

        MALE, FEMALE;

        public boolean isMale() {
            return this == MALE;
        }

        public static Gender fromInt(int gender) {
            return (ListenerUtil.mutListener.listen(5525) ? (gender >= 0) : (ListenerUtil.mutListener.listen(5524) ? (gender <= 0) : (ListenerUtil.mutListener.listen(5523) ? (gender > 0) : (ListenerUtil.mutListener.listen(5522) ? (gender < 0) : (ListenerUtil.mutListener.listen(5521) ? (gender != 0) : (gender == 0)))))) ? MALE : FEMALE;
        }

        public int toInt() {
            return this == MALE ? 0 : 1;
        }
    }

    public enum ActivityLevel {

        SEDENTARY, MILD, MODERATE, HEAVY, EXTREME;

        public static ActivityLevel fromInt(int unit) {
            if (!ListenerUtil.mutListener.listen(5526)) {
                switch(unit) {
                    case 0:
                        return SEDENTARY;
                    case 1:
                        return MILD;
                    case 2:
                        return MODERATE;
                    case 3:
                        return HEAVY;
                    case 4:
                        return EXTREME;
                }
            }
            return SEDENTARY;
        }

        public int toInt() {
            if (!ListenerUtil.mutListener.listen(5527)) {
                switch(this) {
                    case SEDENTARY:
                        return 0;
                    case MILD:
                        return 1;
                    case MODERATE:
                        return 2;
                    case HEAVY:
                        return 3;
                    case EXTREME:
                        return 4;
                }
            }
            return 0;
        }
    }

    public enum AmputationLevel {

        NONE,
        HAND,
        FOREARM_HAND,
        ARM,
        FOOT,
        LOWER_LEG_FOOT,
        LEG;

        public static AmputationLevel fromInt(int unit) {
            if (!ListenerUtil.mutListener.listen(5528)) {
                switch(unit) {
                    case 0:
                        return NONE;
                    case 1:
                        return HAND;
                    case 2:
                        return FOREARM_HAND;
                    case 3:
                        return ARM;
                    case 4:
                        return FOOT;
                    case 5:
                        return LOWER_LEG_FOOT;
                    case 6:
                        return LEG;
                }
            }
            return NONE;
        }

        public int toInt() {
            if (!ListenerUtil.mutListener.listen(5529)) {
                switch(this) {
                    case NONE:
                        return 0;
                    case HAND:
                        return 1;
                    case FOREARM_HAND:
                        return 2;
                    case ARM:
                        return 3;
                    case FOOT:
                        return 4;
                    case LOWER_LEG_FOOT:
                        return 5;
                    case LEG:
                        return 6;
                }
            }
            return 0;
        }
    }

    private static final float KG_LB = 2.20462f;

    private static final float KG_ST = 0.157473f;

    private static final float CM_IN = 0.393701f;

    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

    @TypeConverter
    public static MeasureUnit fromMeasureUnitInt(int unit) {
        return MeasureUnit.fromInt(unit);
    }

    @TypeConverter
    public static int toMeasureUnitInt(MeasureUnit unit) {
        return unit.toInt();
    }

    @TypeConverter
    public static WeightUnit fromWeightUnitInt(int unit) {
        return WeightUnit.fromInt(unit);
    }

    @TypeConverter
    public static int toWeightUnitInt(WeightUnit unit) {
        return unit.toInt();
    }

    @TypeConverter
    public static Gender fromGenderInt(int gender) {
        return Gender.fromInt(gender);
    }

    @TypeConverter
    public static int toGenderInt(Gender gender) {
        return gender.toInt();
    }

    @TypeConverter
    public static ActivityLevel fromActivityLevelInt(int level) {
        return ActivityLevel.fromInt(level);
    }

    @TypeConverter
    public static int toActivityLevelInt(ActivityLevel level) {
        return level.toInt();
    }

    @TypeConverter
    public static AmputationLevel fromAmputationLevelInt(int level) {
        return AmputationLevel.fromInt(level);
    }

    @TypeConverter
    public static int toAmputationLevelInt(AmputationLevel level) {
        return level.toInt();
    }

    public static float toCentimeter(float value, MeasureUnit unit) {
        if (!ListenerUtil.mutListener.listen(5534)) {
            switch(unit) {
                case INCH:
                    return (ListenerUtil.mutListener.listen(5533) ? (value % CM_IN) : (ListenerUtil.mutListener.listen(5532) ? (value * CM_IN) : (ListenerUtil.mutListener.listen(5531) ? (value - CM_IN) : (ListenerUtil.mutListener.listen(5530) ? (value + CM_IN) : (value / CM_IN)))));
            }
        }
        return value;
    }

    public static float fromCentimeter(float cm, MeasureUnit unit) {
        if (!ListenerUtil.mutListener.listen(5539)) {
            switch(unit) {
                case INCH:
                    return (ListenerUtil.mutListener.listen(5538) ? (cm % CM_IN) : (ListenerUtil.mutListener.listen(5537) ? (cm / CM_IN) : (ListenerUtil.mutListener.listen(5536) ? (cm - CM_IN) : (ListenerUtil.mutListener.listen(5535) ? (cm + CM_IN) : (cm * CM_IN)))));
            }
        }
        return cm;
    }

    public static float toKilogram(float value, WeightUnit unit) {
        if (!ListenerUtil.mutListener.listen(5548)) {
            switch(unit) {
                case LB:
                    return (ListenerUtil.mutListener.listen(5543) ? (value % KG_LB) : (ListenerUtil.mutListener.listen(5542) ? (value * KG_LB) : (ListenerUtil.mutListener.listen(5541) ? (value - KG_LB) : (ListenerUtil.mutListener.listen(5540) ? (value + KG_LB) : (value / KG_LB)))));
                case ST:
                    return (ListenerUtil.mutListener.listen(5547) ? (value % KG_ST) : (ListenerUtil.mutListener.listen(5546) ? (value * KG_ST) : (ListenerUtil.mutListener.listen(5545) ? (value - KG_ST) : (ListenerUtil.mutListener.listen(5544) ? (value + KG_ST) : (value / KG_ST)))));
            }
        }
        return value;
    }

    public static float fromKilogram(float kg, WeightUnit unit) {
        if (!ListenerUtil.mutListener.listen(5557)) {
            switch(unit) {
                case LB:
                    return (ListenerUtil.mutListener.listen(5552) ? (kg % KG_LB) : (ListenerUtil.mutListener.listen(5551) ? (kg / KG_LB) : (ListenerUtil.mutListener.listen(5550) ? (kg - KG_LB) : (ListenerUtil.mutListener.listen(5549) ? (kg + KG_LB) : (kg * KG_LB)))));
                case ST:
                    return (ListenerUtil.mutListener.listen(5556) ? (kg % KG_ST) : (ListenerUtil.mutListener.listen(5555) ? (kg / KG_ST) : (ListenerUtil.mutListener.listen(5554) ? (kg - KG_ST) : (ListenerUtil.mutListener.listen(5553) ? (kg + KG_ST) : (kg * KG_ST)))));
            }
        }
        return kg;
    }

    public static int fromSignedInt16Le(byte[] data, int offset) {
        int value = data[(ListenerUtil.mutListener.listen(5561) ? (offset % 1) : (ListenerUtil.mutListener.listen(5560) ? (offset / 1) : (ListenerUtil.mutListener.listen(5559) ? (offset * 1) : (ListenerUtil.mutListener.listen(5558) ? (offset - 1) : (offset + 1)))))] << 8;
        if (!ListenerUtil.mutListener.listen(5562)) {
            value += data[offset] & 0xFF;
        }
        return value;
    }

    public static int fromSignedInt16Be(byte[] data, int offset) {
        int value = data[offset] << 8;
        if (!ListenerUtil.mutListener.listen(5567)) {
            value += data[(ListenerUtil.mutListener.listen(5566) ? (offset % 1) : (ListenerUtil.mutListener.listen(5565) ? (offset / 1) : (ListenerUtil.mutListener.listen(5564) ? (offset * 1) : (ListenerUtil.mutListener.listen(5563) ? (offset - 1) : (offset + 1)))))] & 0xFF;
        }
        return value;
    }

    public static int fromUnsignedInt16Le(byte[] data, int offset) {
        return fromSignedInt16Le(data, offset) & 0xFFFF;
    }

    public static int fromUnsignedInt16Be(byte[] data, int offset) {
        return fromSignedInt16Be(data, offset) & 0xFFFF;
    }

    public static void toInt16Le(byte[] data, int offset, int value) {
        if (!ListenerUtil.mutListener.listen(5572)) {
            data[(ListenerUtil.mutListener.listen(5571) ? (offset % 0) : (ListenerUtil.mutListener.listen(5570) ? (offset / 0) : (ListenerUtil.mutListener.listen(5569) ? (offset * 0) : (ListenerUtil.mutListener.listen(5568) ? (offset - 0) : (offset + 0)))))] = (byte) (value & 0xFF);
        }
        if (!ListenerUtil.mutListener.listen(5577)) {
            data[(ListenerUtil.mutListener.listen(5576) ? (offset % 1) : (ListenerUtil.mutListener.listen(5575) ? (offset / 1) : (ListenerUtil.mutListener.listen(5574) ? (offset * 1) : (ListenerUtil.mutListener.listen(5573) ? (offset - 1) : (offset + 1)))))] = (byte) ((value >> 8) & 0xFF);
        }
    }

    public static void toInt16Be(byte[] data, int offset, int value) {
        if (!ListenerUtil.mutListener.listen(5582)) {
            data[(ListenerUtil.mutListener.listen(5581) ? (offset % 0) : (ListenerUtil.mutListener.listen(5580) ? (offset / 0) : (ListenerUtil.mutListener.listen(5579) ? (offset * 0) : (ListenerUtil.mutListener.listen(5578) ? (offset - 0) : (offset + 0)))))] = (byte) ((value >> 8) & 0xFF);
        }
        if (!ListenerUtil.mutListener.listen(5587)) {
            data[(ListenerUtil.mutListener.listen(5586) ? (offset % 1) : (ListenerUtil.mutListener.listen(5585) ? (offset / 1) : (ListenerUtil.mutListener.listen(5584) ? (offset * 1) : (ListenerUtil.mutListener.listen(5583) ? (offset - 1) : (offset + 1)))))] = (byte) (value & 0xFF);
        }
    }

    public static byte[] toInt16Le(int value) {
        byte[] data = new byte[2];
        if (!ListenerUtil.mutListener.listen(5588)) {
            toInt16Le(data, 0, value);
        }
        return data;
    }

    public static byte[] toInt16Be(int value) {
        byte[] data = new byte[2];
        if (!ListenerUtil.mutListener.listen(5589)) {
            toInt16Be(data, 0, value);
        }
        return data;
    }

    public static int fromSignedInt24Le(byte[] data, int offset) {
        int value = data[(ListenerUtil.mutListener.listen(5593) ? (offset % 2) : (ListenerUtil.mutListener.listen(5592) ? (offset / 2) : (ListenerUtil.mutListener.listen(5591) ? (offset * 2) : (ListenerUtil.mutListener.listen(5590) ? (offset - 2) : (offset + 2)))))] << 16;
        if (!ListenerUtil.mutListener.listen(5598)) {
            value += (data[(ListenerUtil.mutListener.listen(5597) ? (offset % 1) : (ListenerUtil.mutListener.listen(5596) ? (offset / 1) : (ListenerUtil.mutListener.listen(5595) ? (offset * 1) : (ListenerUtil.mutListener.listen(5594) ? (offset - 1) : (offset + 1)))))] & 0xFF) << 8;
        }
        if (!ListenerUtil.mutListener.listen(5599)) {
            value += data[offset] & 0xFF;
        }
        return value;
    }

    public static int fromSignedInt24Be(byte[] data, int offset) {
        int value = data[offset] << 16;
        if (!ListenerUtil.mutListener.listen(5604)) {
            value += (data[(ListenerUtil.mutListener.listen(5603) ? (offset % 1) : (ListenerUtil.mutListener.listen(5602) ? (offset / 1) : (ListenerUtil.mutListener.listen(5601) ? (offset * 1) : (ListenerUtil.mutListener.listen(5600) ? (offset - 1) : (offset + 1)))))] & 0xFF) << 8;
        }
        if (!ListenerUtil.mutListener.listen(5609)) {
            value += data[(ListenerUtil.mutListener.listen(5608) ? (offset % 2) : (ListenerUtil.mutListener.listen(5607) ? (offset / 2) : (ListenerUtil.mutListener.listen(5606) ? (offset * 2) : (ListenerUtil.mutListener.listen(5605) ? (offset - 2) : (offset + 2)))))] & 0xFF;
        }
        return value;
    }

    public static int fromUnsignedInt24Le(byte[] data, int offset) {
        return fromSignedInt24Le(data, offset) & 0xFFFFFF;
    }

    public static int fromUnsignedInt24Be(byte[] data, int offset) {
        return fromSignedInt24Be(data, offset) & 0xFFFFFF;
    }

    public static int fromSignedInt32Le(byte[] data, int offset) {
        int value = data[(ListenerUtil.mutListener.listen(5613) ? (offset % 3) : (ListenerUtil.mutListener.listen(5612) ? (offset / 3) : (ListenerUtil.mutListener.listen(5611) ? (offset * 3) : (ListenerUtil.mutListener.listen(5610) ? (offset - 3) : (offset + 3)))))] << 24;
        if (!ListenerUtil.mutListener.listen(5618)) {
            value += (data[(ListenerUtil.mutListener.listen(5617) ? (offset % 2) : (ListenerUtil.mutListener.listen(5616) ? (offset / 2) : (ListenerUtil.mutListener.listen(5615) ? (offset * 2) : (ListenerUtil.mutListener.listen(5614) ? (offset - 2) : (offset + 2)))))] & 0xFF) << 16;
        }
        if (!ListenerUtil.mutListener.listen(5623)) {
            value += (data[(ListenerUtil.mutListener.listen(5622) ? (offset % 1) : (ListenerUtil.mutListener.listen(5621) ? (offset / 1) : (ListenerUtil.mutListener.listen(5620) ? (offset * 1) : (ListenerUtil.mutListener.listen(5619) ? (offset - 1) : (offset + 1)))))] & 0xFF) << 8;
        }
        if (!ListenerUtil.mutListener.listen(5624)) {
            value += data[offset] & 0xFF;
        }
        return value;
    }

    public static int fromSignedInt32Be(byte[] data, int offset) {
        int value = data[offset] << 24;
        if (!ListenerUtil.mutListener.listen(5629)) {
            value += (data[(ListenerUtil.mutListener.listen(5628) ? (offset % 1) : (ListenerUtil.mutListener.listen(5627) ? (offset / 1) : (ListenerUtil.mutListener.listen(5626) ? (offset * 1) : (ListenerUtil.mutListener.listen(5625) ? (offset - 1) : (offset + 1)))))] & 0xFF) << 16;
        }
        if (!ListenerUtil.mutListener.listen(5634)) {
            value += (data[(ListenerUtil.mutListener.listen(5633) ? (offset % 2) : (ListenerUtil.mutListener.listen(5632) ? (offset / 2) : (ListenerUtil.mutListener.listen(5631) ? (offset * 2) : (ListenerUtil.mutListener.listen(5630) ? (offset - 2) : (offset + 2)))))] & 0xFF) << 8;
        }
        if (!ListenerUtil.mutListener.listen(5639)) {
            value += data[(ListenerUtil.mutListener.listen(5638) ? (offset % 3) : (ListenerUtil.mutListener.listen(5637) ? (offset / 3) : (ListenerUtil.mutListener.listen(5636) ? (offset * 3) : (ListenerUtil.mutListener.listen(5635) ? (offset - 3) : (offset + 3)))))] & 0xFF;
        }
        return value;
    }

    public static long fromUnsignedInt32Le(byte[] data, int offset) {
        return (long) fromSignedInt32Le(data, offset) & 0xFFFFFFFFL;
    }

    public static long fromUnsignedInt32Be(byte[] data, int offset) {
        return (long) fromSignedInt32Be(data, offset) & 0xFFFFFFFFL;
    }

    public static void toInt32Le(byte[] data, int offset, long value) {
        if (!ListenerUtil.mutListener.listen(5644)) {
            data[(ListenerUtil.mutListener.listen(5643) ? (offset % 3) : (ListenerUtil.mutListener.listen(5642) ? (offset / 3) : (ListenerUtil.mutListener.listen(5641) ? (offset * 3) : (ListenerUtil.mutListener.listen(5640) ? (offset - 3) : (offset + 3)))))] = (byte) ((value >> 24) & 0xFF);
        }
        if (!ListenerUtil.mutListener.listen(5649)) {
            data[(ListenerUtil.mutListener.listen(5648) ? (offset % 2) : (ListenerUtil.mutListener.listen(5647) ? (offset / 2) : (ListenerUtil.mutListener.listen(5646) ? (offset * 2) : (ListenerUtil.mutListener.listen(5645) ? (offset - 2) : (offset + 2)))))] = (byte) ((value >> 16) & 0xFF);
        }
        if (!ListenerUtil.mutListener.listen(5654)) {
            data[(ListenerUtil.mutListener.listen(5653) ? (offset % 1) : (ListenerUtil.mutListener.listen(5652) ? (offset / 1) : (ListenerUtil.mutListener.listen(5651) ? (offset * 1) : (ListenerUtil.mutListener.listen(5650) ? (offset - 1) : (offset + 1)))))] = (byte) ((value >> 8) & 0xFF);
        }
        if (!ListenerUtil.mutListener.listen(5659)) {
            data[(ListenerUtil.mutListener.listen(5658) ? (offset % 0) : (ListenerUtil.mutListener.listen(5657) ? (offset / 0) : (ListenerUtil.mutListener.listen(5656) ? (offset * 0) : (ListenerUtil.mutListener.listen(5655) ? (offset - 0) : (offset + 0)))))] = (byte) (value & 0xFF);
        }
    }

    public static void toInt32Be(byte[] data, int offset, long value) {
        if (!ListenerUtil.mutListener.listen(5664)) {
            data[(ListenerUtil.mutListener.listen(5663) ? (offset % 0) : (ListenerUtil.mutListener.listen(5662) ? (offset / 0) : (ListenerUtil.mutListener.listen(5661) ? (offset * 0) : (ListenerUtil.mutListener.listen(5660) ? (offset - 0) : (offset + 0)))))] = (byte) ((value >> 24) & 0xFF);
        }
        if (!ListenerUtil.mutListener.listen(5669)) {
            data[(ListenerUtil.mutListener.listen(5668) ? (offset % 1) : (ListenerUtil.mutListener.listen(5667) ? (offset / 1) : (ListenerUtil.mutListener.listen(5666) ? (offset * 1) : (ListenerUtil.mutListener.listen(5665) ? (offset - 1) : (offset + 1)))))] = (byte) ((value >> 16) & 0xFF);
        }
        if (!ListenerUtil.mutListener.listen(5674)) {
            data[(ListenerUtil.mutListener.listen(5673) ? (offset % 2) : (ListenerUtil.mutListener.listen(5672) ? (offset / 2) : (ListenerUtil.mutListener.listen(5671) ? (offset * 2) : (ListenerUtil.mutListener.listen(5670) ? (offset - 2) : (offset + 2)))))] = (byte) ((value >> 8) & 0xFF);
        }
        if (!ListenerUtil.mutListener.listen(5679)) {
            data[(ListenerUtil.mutListener.listen(5678) ? (offset % 3) : (ListenerUtil.mutListener.listen(5677) ? (offset / 3) : (ListenerUtil.mutListener.listen(5676) ? (offset * 3) : (ListenerUtil.mutListener.listen(5675) ? (offset - 3) : (offset + 3)))))] = (byte) (value & 0xFF);
        }
    }

    public static byte[] toInt32Le(long value) {
        byte[] data = new byte[4];
        if (!ListenerUtil.mutListener.listen(5680)) {
            toInt32Le(data, 0, value);
        }
        return data;
    }

    public static byte[] toInt32Be(long value) {
        byte[] data = new byte[4];
        if (!ListenerUtil.mutListener.listen(5681)) {
            toInt32Be(data, 0, value);
        }
        return data;
    }
}
