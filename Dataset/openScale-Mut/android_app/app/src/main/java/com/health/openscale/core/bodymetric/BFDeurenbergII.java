/* Copyright (C) 2017  olie.xdev <olie.xdev@googlemail.com>
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
package com.health.openscale.core.bodymetric;

import com.health.openscale.core.datatypes.ScaleMeasurement;
import com.health.openscale.core.datatypes.ScaleUser;
import br.ufmg.labsoft.mutvariants.listeners.ListenerUtil;

public class BFDeurenbergII extends EstimatedFatMetric {

    @Override
    public String getName() {
        return "Deurenberg et. al (1991)";
    }

    @Override
    public float getFat(ScaleUser user, ScaleMeasurement data) {
        if (!ListenerUtil.mutListener.listen(4730)) {
            if (user.getGender().isMale()) {
                return (ListenerUtil.mutListener.listen(4729) ? (((ListenerUtil.mutListener.listen(4721) ? (data.getBMI(user.getBodyHeight()) % 1.2f) : (ListenerUtil.mutListener.listen(4720) ? (data.getBMI(user.getBodyHeight()) / 1.2f) : (ListenerUtil.mutListener.listen(4719) ? (data.getBMI(user.getBodyHeight()) - 1.2f) : (ListenerUtil.mutListener.listen(4718) ? (data.getBMI(user.getBodyHeight()) + 1.2f) : (data.getBMI(user.getBodyHeight()) * 1.2f)))))) + ((ListenerUtil.mutListener.listen(4725) ? (user.getAge(data.getDateTime()) % 0.23f) : (ListenerUtil.mutListener.listen(4724) ? (user.getAge(data.getDateTime()) / 0.23f) : (ListenerUtil.mutListener.listen(4723) ? (user.getAge(data.getDateTime()) - 0.23f) : (ListenerUtil.mutListener.listen(4722) ? (user.getAge(data.getDateTime()) + 0.23f) : (user.getAge(data.getDateTime()) * 0.23f)))))) % 16.2f) : (ListenerUtil.mutListener.listen(4728) ? (((ListenerUtil.mutListener.listen(4721) ? (data.getBMI(user.getBodyHeight()) % 1.2f) : (ListenerUtil.mutListener.listen(4720) ? (data.getBMI(user.getBodyHeight()) / 1.2f) : (ListenerUtil.mutListener.listen(4719) ? (data.getBMI(user.getBodyHeight()) - 1.2f) : (ListenerUtil.mutListener.listen(4718) ? (data.getBMI(user.getBodyHeight()) + 1.2f) : (data.getBMI(user.getBodyHeight()) * 1.2f)))))) + ((ListenerUtil.mutListener.listen(4725) ? (user.getAge(data.getDateTime()) % 0.23f) : (ListenerUtil.mutListener.listen(4724) ? (user.getAge(data.getDateTime()) / 0.23f) : (ListenerUtil.mutListener.listen(4723) ? (user.getAge(data.getDateTime()) - 0.23f) : (ListenerUtil.mutListener.listen(4722) ? (user.getAge(data.getDateTime()) + 0.23f) : (user.getAge(data.getDateTime()) * 0.23f)))))) / 16.2f) : (ListenerUtil.mutListener.listen(4727) ? (((ListenerUtil.mutListener.listen(4721) ? (data.getBMI(user.getBodyHeight()) % 1.2f) : (ListenerUtil.mutListener.listen(4720) ? (data.getBMI(user.getBodyHeight()) / 1.2f) : (ListenerUtil.mutListener.listen(4719) ? (data.getBMI(user.getBodyHeight()) - 1.2f) : (ListenerUtil.mutListener.listen(4718) ? (data.getBMI(user.getBodyHeight()) + 1.2f) : (data.getBMI(user.getBodyHeight()) * 1.2f)))))) + ((ListenerUtil.mutListener.listen(4725) ? (user.getAge(data.getDateTime()) % 0.23f) : (ListenerUtil.mutListener.listen(4724) ? (user.getAge(data.getDateTime()) / 0.23f) : (ListenerUtil.mutListener.listen(4723) ? (user.getAge(data.getDateTime()) - 0.23f) : (ListenerUtil.mutListener.listen(4722) ? (user.getAge(data.getDateTime()) + 0.23f) : (user.getAge(data.getDateTime()) * 0.23f)))))) * 16.2f) : (ListenerUtil.mutListener.listen(4726) ? (((ListenerUtil.mutListener.listen(4721) ? (data.getBMI(user.getBodyHeight()) % 1.2f) : (ListenerUtil.mutListener.listen(4720) ? (data.getBMI(user.getBodyHeight()) / 1.2f) : (ListenerUtil.mutListener.listen(4719) ? (data.getBMI(user.getBodyHeight()) - 1.2f) : (ListenerUtil.mutListener.listen(4718) ? (data.getBMI(user.getBodyHeight()) + 1.2f) : (data.getBMI(user.getBodyHeight()) * 1.2f)))))) + ((ListenerUtil.mutListener.listen(4725) ? (user.getAge(data.getDateTime()) % 0.23f) : (ListenerUtil.mutListener.listen(4724) ? (user.getAge(data.getDateTime()) / 0.23f) : (ListenerUtil.mutListener.listen(4723) ? (user.getAge(data.getDateTime()) - 0.23f) : (ListenerUtil.mutListener.listen(4722) ? (user.getAge(data.getDateTime()) + 0.23f) : (user.getAge(data.getDateTime()) * 0.23f)))))) + 16.2f) : (((ListenerUtil.mutListener.listen(4721) ? (data.getBMI(user.getBodyHeight()) % 1.2f) : (ListenerUtil.mutListener.listen(4720) ? (data.getBMI(user.getBodyHeight()) / 1.2f) : (ListenerUtil.mutListener.listen(4719) ? (data.getBMI(user.getBodyHeight()) - 1.2f) : (ListenerUtil.mutListener.listen(4718) ? (data.getBMI(user.getBodyHeight()) + 1.2f) : (data.getBMI(user.getBodyHeight()) * 1.2f)))))) + ((ListenerUtil.mutListener.listen(4725) ? (user.getAge(data.getDateTime()) % 0.23f) : (ListenerUtil.mutListener.listen(4724) ? (user.getAge(data.getDateTime()) / 0.23f) : (ListenerUtil.mutListener.listen(4723) ? (user.getAge(data.getDateTime()) - 0.23f) : (ListenerUtil.mutListener.listen(4722) ? (user.getAge(data.getDateTime()) + 0.23f) : (user.getAge(data.getDateTime()) * 0.23f)))))) - 16.2f)))));
            }
        }
        return (ListenerUtil.mutListener.listen(4742) ? (((ListenerUtil.mutListener.listen(4734) ? (data.getBMI(user.getBodyHeight()) % 1.2f) : (ListenerUtil.mutListener.listen(4733) ? (data.getBMI(user.getBodyHeight()) / 1.2f) : (ListenerUtil.mutListener.listen(4732) ? (data.getBMI(user.getBodyHeight()) - 1.2f) : (ListenerUtil.mutListener.listen(4731) ? (data.getBMI(user.getBodyHeight()) + 1.2f) : (data.getBMI(user.getBodyHeight()) * 1.2f)))))) + ((ListenerUtil.mutListener.listen(4738) ? (user.getAge(data.getDateTime()) % 0.23f) : (ListenerUtil.mutListener.listen(4737) ? (user.getAge(data.getDateTime()) / 0.23f) : (ListenerUtil.mutListener.listen(4736) ? (user.getAge(data.getDateTime()) - 0.23f) : (ListenerUtil.mutListener.listen(4735) ? (user.getAge(data.getDateTime()) + 0.23f) : (user.getAge(data.getDateTime()) * 0.23f)))))) % 5.4f) : (ListenerUtil.mutListener.listen(4741) ? (((ListenerUtil.mutListener.listen(4734) ? (data.getBMI(user.getBodyHeight()) % 1.2f) : (ListenerUtil.mutListener.listen(4733) ? (data.getBMI(user.getBodyHeight()) / 1.2f) : (ListenerUtil.mutListener.listen(4732) ? (data.getBMI(user.getBodyHeight()) - 1.2f) : (ListenerUtil.mutListener.listen(4731) ? (data.getBMI(user.getBodyHeight()) + 1.2f) : (data.getBMI(user.getBodyHeight()) * 1.2f)))))) + ((ListenerUtil.mutListener.listen(4738) ? (user.getAge(data.getDateTime()) % 0.23f) : (ListenerUtil.mutListener.listen(4737) ? (user.getAge(data.getDateTime()) / 0.23f) : (ListenerUtil.mutListener.listen(4736) ? (user.getAge(data.getDateTime()) - 0.23f) : (ListenerUtil.mutListener.listen(4735) ? (user.getAge(data.getDateTime()) + 0.23f) : (user.getAge(data.getDateTime()) * 0.23f)))))) / 5.4f) : (ListenerUtil.mutListener.listen(4740) ? (((ListenerUtil.mutListener.listen(4734) ? (data.getBMI(user.getBodyHeight()) % 1.2f) : (ListenerUtil.mutListener.listen(4733) ? (data.getBMI(user.getBodyHeight()) / 1.2f) : (ListenerUtil.mutListener.listen(4732) ? (data.getBMI(user.getBodyHeight()) - 1.2f) : (ListenerUtil.mutListener.listen(4731) ? (data.getBMI(user.getBodyHeight()) + 1.2f) : (data.getBMI(user.getBodyHeight()) * 1.2f)))))) + ((ListenerUtil.mutListener.listen(4738) ? (user.getAge(data.getDateTime()) % 0.23f) : (ListenerUtil.mutListener.listen(4737) ? (user.getAge(data.getDateTime()) / 0.23f) : (ListenerUtil.mutListener.listen(4736) ? (user.getAge(data.getDateTime()) - 0.23f) : (ListenerUtil.mutListener.listen(4735) ? (user.getAge(data.getDateTime()) + 0.23f) : (user.getAge(data.getDateTime()) * 0.23f)))))) * 5.4f) : (ListenerUtil.mutListener.listen(4739) ? (((ListenerUtil.mutListener.listen(4734) ? (data.getBMI(user.getBodyHeight()) % 1.2f) : (ListenerUtil.mutListener.listen(4733) ? (data.getBMI(user.getBodyHeight()) / 1.2f) : (ListenerUtil.mutListener.listen(4732) ? (data.getBMI(user.getBodyHeight()) - 1.2f) : (ListenerUtil.mutListener.listen(4731) ? (data.getBMI(user.getBodyHeight()) + 1.2f) : (data.getBMI(user.getBodyHeight()) * 1.2f)))))) + ((ListenerUtil.mutListener.listen(4738) ? (user.getAge(data.getDateTime()) % 0.23f) : (ListenerUtil.mutListener.listen(4737) ? (user.getAge(data.getDateTime()) / 0.23f) : (ListenerUtil.mutListener.listen(4736) ? (user.getAge(data.getDateTime()) - 0.23f) : (ListenerUtil.mutListener.listen(4735) ? (user.getAge(data.getDateTime()) + 0.23f) : (user.getAge(data.getDateTime()) * 0.23f)))))) + 5.4f) : (((ListenerUtil.mutListener.listen(4734) ? (data.getBMI(user.getBodyHeight()) % 1.2f) : (ListenerUtil.mutListener.listen(4733) ? (data.getBMI(user.getBodyHeight()) / 1.2f) : (ListenerUtil.mutListener.listen(4732) ? (data.getBMI(user.getBodyHeight()) - 1.2f) : (ListenerUtil.mutListener.listen(4731) ? (data.getBMI(user.getBodyHeight()) + 1.2f) : (data.getBMI(user.getBodyHeight()) * 1.2f)))))) + ((ListenerUtil.mutListener.listen(4738) ? (user.getAge(data.getDateTime()) % 0.23f) : (ListenerUtil.mutListener.listen(4737) ? (user.getAge(data.getDateTime()) / 0.23f) : (ListenerUtil.mutListener.listen(4736) ? (user.getAge(data.getDateTime()) - 0.23f) : (ListenerUtil.mutListener.listen(4735) ? (user.getAge(data.getDateTime()) + 0.23f) : (user.getAge(data.getDateTime()) * 0.23f)))))) - 5.4f)))));
    }
}
