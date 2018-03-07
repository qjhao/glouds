package sin.glouds.util.weather;

import java.util.List;

public class WeatherInfo {
	private String city;
	private String updatetime;
	private String wendu;
	private String fengli;
	private String shidu;
	private String fengxiang;
	private String sunrise_1;
	private String sunset_1;
	private String sunrise_2;
	private String sunset_2;
	private Alarm alarm;
	private Yesterday yesterday;
	private List<Weather> forecast;
	private List<Zhishu> zhishus;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getWendu() {
		return wendu;
	}

	public void setWendu(String wendu) {
		this.wendu = wendu;
	}

	public String getFengli() {
		return fengli;
	}

	public void setFengli(String fengli) {
		this.fengli = fengli;
	}

	public String getShidu() {
		return shidu;
	}

	public void setShidu(String shidu) {
		this.shidu = shidu;
	}

	public String getFengxiang() {
		return fengxiang;
	}

	public void setFengxiang(String fengxiang) {
		this.fengxiang = fengxiang;
	}

	public String getSunrise_1() {
		return sunrise_1;
	}

	public void setSunrise_1(String sunrise_1) {
		this.sunrise_1 = sunrise_1;
	}

	public String getSunset_1() {
		return sunset_1;
	}

	public void setSunset_1(String sunset_1) {
		this.sunset_1 = sunset_1;
	}

	public String getSunrise_2() {
		return sunrise_2;
	}

	public void setSunrise_2(String sunrise_2) {
		this.sunrise_2 = sunrise_2;
	}

	public String getSunset_2() {
		return sunset_2;
	}

	public void setSunset_2(String sunset_2) {
		this.sunset_2 = sunset_2;
	}

	public Alarm getAlarm() {
		return alarm;
	}

	public void setAlarm(Alarm alarm) {
		this.alarm = alarm;
	}

	public Yesterday getYesterday() {
		return yesterday;
	}

	public void setYesterday(Yesterday yesterday) {
		this.yesterday = yesterday;
	}

	public List<Weather> getForecast() {
		return forecast;
	}

	public void setForecast(List<Weather> forecast) {
		this.forecast = forecast;
	}

	public List<Zhishu> getZhishus() {
		return zhishus;
	}

	public void setZhishus(List<Zhishu> zhishus) {
		this.zhishus = zhishus;
	}

	public static class Alarm {
		private String cityKey;
		private String cityName;
		private String alarmType;
		private String alermDegree;
		private String alarmText;
		private String alarm_details;
		private String standard;
		private String suggest;
		private String imgUrl;
		private String time;

		public String getCityKey() {
			return cityKey;
		}

		public void setCityKey(String cityKey) {
			this.cityKey = cityKey;
		}

		public String getCityName() {
			return cityName;
		}

		public void setCityName(String cityName) {
			this.cityName = cityName;
		}

		public String getAlarmType() {
			return alarmType;
		}

		public void setAlarmType(String alarmType) {
			this.alarmType = alarmType;
		}

		public String getAlermDegree() {
			return alermDegree;
		}

		public void setAlermDegree(String alermDegree) {
			this.alermDegree = alermDegree;
		}

		public String getAlarmText() {
			return alarmText;
		}

		public void setAlarmText(String alarmText) {
			this.alarmText = alarmText;
		}

		public String getAlarm_details() {
			return alarm_details;
		}

		public void setAlarm_details(String alarm_details) {
			this.alarm_details = alarm_details;
		}

		public String getStandard() {
			return standard;
		}

		public void setStandard(String standard) {
			this.standard = standard;
		}

		public String getSuggest() {
			return suggest;
		}

		public void setSuggest(String suggest) {
			this.suggest = suggest;
		}

		public String getImgUrl() {
			return imgUrl;
		}

		public void setImgUrl(String imgUrl) {
			this.imgUrl = imgUrl;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		@Override
		public String toString() {
			return "Alarm [cityKey=" + cityKey + ", cityName=" + cityName + ", alarmType=" + alarmType
					+ ", alermDegree=" + alermDegree + ", alarmText=" + alarmText + ", alarm_details=" + alarm_details
					+ ", standard=" + standard + ", suggest=" + suggest + ", imgUrl=" + imgUrl + ", time=" + time + "]";
		}

	}

	public static class Yesterday {
		private String date_1;
		private String high_1;
		private String low_1;
		private DayNight day_1;
		private DayNight night_1;

		public String getDate_1() {
			return date_1;
		}

		public void setDate_1(String date_1) {
			this.date_1 = date_1;
		}

		public String getHigh_1() {
			return high_1;
		}

		public void setHigh_1(String high_1) {
			this.high_1 = high_1;
		}

		public String getLow_1() {
			return low_1;
		}

		public void setLow_1(String low_1) {
			this.low_1 = low_1;
		}

		public DayNight getDay_1() {
			return day_1;
		}

		public void setDay_1(DayNight day_1) {
			this.day_1 = day_1;
		}

		public DayNight getNight_1() {
			return night_1;
		}

		public void setNight_1(DayNight night_1) {
			this.night_1 = night_1;
		}

		@Override
		public String toString() {
			return "Yesterday [date_1=" + date_1 + ", high_1=" + high_1 + ", low_1=" + low_1 + ", day_1=" + day_1
					+ ", night_1=" + night_1 + "]";
		}

	}

	public static class DayNight {
		private String type_1;
		private String fx_1;
		private String fl_1;

		public String getType_1() {
			return type_1;
		}

		public void setType_1(String type_1) {
			this.type_1 = type_1;
		}

		public String getFx_1() {
			return fx_1;
		}

		public void setFx_1(String fx_1) {
			this.fx_1 = fx_1;
		}

		public String getFl_1() {
			return fl_1;
		}

		public void setFl_1(String fl_1) {
			this.fl_1 = fl_1;
		}

		@Override
		public String toString() {
			return "DayNight [type_1=" + type_1 + ", fx_1=" + fx_1 + ", fl_1=" + fl_1 + "]";
		}

	}

	public static class Weather {
		private String date;
		private String high;
		private String low;
		private DayNight day;
		private DayNight night;

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getHigh() {
			return high;
		}

		public void setHigh(String high) {
			this.high = high;
		}

		public String getLow() {
			return low;
		}

		public void setLow(String low) {
			this.low = low;
		}

		public DayNight getDay() {
			return day;
		}

		public void setDay(DayNight day) {
			this.day = day;
		}

		public DayNight getNight() {
			return night;
		}

		public void setNight(DayNight night) {
			this.night = night;
		}

		@Override
		public String toString() {
			return "Weather [date=" + date + ", high=" + high + ", low=" + low + ", day=" + day + ", night=" + night
					+ "]";
		}

	}

	public static class Zhishu {
		private String name;
		private String value;
		private String detail;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getDetail() {
			return detail;
		}

		public void setDetail(String detail) {
			this.detail = detail;
		}

		@Override
		public String toString() {
			return "Zhishu [name=" + name + ", value=" + value + ", detail=" + detail + "]";
		}

	}

	@Override
	public String toString() {
		return "WeatherInfo [city=" + city + ", updatetime=" + updatetime + ", wendu=" + wendu + ", fengli=" + fengli
				+ ", shidu=" + shidu + ", fengxiang=" + fengxiang + ", sunrise_1=" + sunrise_1 + ", sunset_1="
				+ sunset_1 + ", sunrise_2=" + sunrise_2 + ", sunset_2=" + sunset_2 + ", alarm=" + (alarm == null ? " " : alarm.toString())
				+ ", yesterday=" + yesterday.toString() + ", forecast=" + forecast.toString() + ", zhishus="
				+ zhishus.toString() + "]";
	}

}
