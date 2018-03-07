package sin.glouds.util.weather;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class WeatherXmlParser {
	@SuppressWarnings("unchecked")
	public static WeatherInfo parser(String xmlStr) throws DocumentException, IOException {
		Document document = DocumentHelper.parseText(xmlStr);// WeatherUtil.getWeatherXmlByName("莱州")
		Element root = document.getRootElement();
		WeatherInfo info = new WeatherInfo();
		info.setCity(root.elementText("city"));
		info.setFengli(root.elementText("fengli"));
		info.setFengxiang(root.elementText("fengxiang"));
		info.setShidu(root.elementText("shidu"));
		info.setSunrise_1(root.elementText("sunrise_1"));
		info.setSunrise_2(root.elementText("sunrise_2"));
		info.setSunset_1(root.elementText("sunset_1"));
		info.setSunset_2(root.elementText("sunset_2"));
		info.setUpdatetime(root.elementText("updatetime"));
		info.setWendu(root.elementText("wendu"));
		Element element1 = root.element("alarm");
		if (element1 != null) {
			WeatherInfo.Alarm alarm = new WeatherInfo.Alarm();
			alarm.setAlarm_details(element1.elementText("alarm_details"));
			alarm.setAlarmText(element1.elementText("alarmText"));
			alarm.setAlarmType(element1.elementText("alarmType"));
			alarm.setAlermDegree(element1.elementText("alarmDegree"));
			alarm.setCityKey(element1.elementText("cityKey"));
			alarm.setCityName(element1.elementText("cityName"));
			alarm.setImgUrl(element1.elementText("imgUrl"));
			alarm.setStandard(element1.elementText("standard"));
			alarm.setSuggest(element1.elementText("suggest"));
			alarm.setTime(element1.elementText("time"));
			info.setAlarm(alarm);
		}

		List<Element> element2 = root.element("forecast").elements("weather");
		List<WeatherInfo.Weather> forecasts = new ArrayList<>();
		for (Element element : element2) {
			WeatherInfo.Weather weather = new WeatherInfo.Weather();
			weather.setDate(element.elementText("date"));
			WeatherInfo.DayNight day = new WeatherInfo.DayNight(), night = new WeatherInfo.DayNight();
			Element de = element.element("day");
			day.setFl_1(de.elementText("fengli"));
			day.setFx_1(de.elementText("fengxiang"));
			day.setType_1(de.elementText("type"));

			Element ne = element.element("night");
			night.setFl_1(ne.elementText("fengli"));
			night.setFx_1(ne.elementText("fengxiang"));
			night.setType_1(ne.elementText("type"));

			weather.setDay(day);
			weather.setNight(night);
			weather.setHigh(element.elementText("high"));
			weather.setLow(element.elementText("low"));
			forecasts.add(weather);
		}

		info.setForecast(forecasts);

		WeatherInfo.Yesterday yesterday = new WeatherInfo.Yesterday();
		Element element3 = root.element("yesterday");
		yesterday.setDate_1(element3.elementText("date_1"));

		WeatherInfo.DayNight day = new WeatherInfo.DayNight(), night = new WeatherInfo.DayNight();
		Element de = element3.element("day_1");
		day.setFl_1(de.elementText("fl_1"));
		day.setFx_1(de.elementText("fx_1"));
		day.setType_1(de.elementText("type_1"));

		Element ne = element3.element("night_1");
		night.setFl_1(ne.elementText("fl_1"));
		night.setFx_1(ne.elementText("fx_1"));
		night.setType_1(ne.elementText("type_1"));

		yesterday.setDay_1(day);
		yesterday.setHigh_1(element3.elementText("high_1"));
		yesterday.setLow_1(element3.elementText("low_1"));
		yesterday.setNight_1(night);
		info.setYesterday(yesterday);

		List<WeatherInfo.Zhishu> zhishus = new ArrayList<>();
		List<Element> element4 = root.element("zhishus").elements("zhishu");
		for (Element element : element4) {
			WeatherInfo.Zhishu zhishu = new WeatherInfo.Zhishu();
			zhishu.setName(element.elementText("name"));
			zhishu.setDetail(element.elementText("detail"));
			zhishu.setValue(element.elementText("value"));
			zhishus.add(zhishu);
		}

		info.setZhishus(zhishus);

		return info;
	}
}
