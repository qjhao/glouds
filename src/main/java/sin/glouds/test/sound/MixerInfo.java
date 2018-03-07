package sin.glouds.test.sound;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.sound.sampled.Mixer;
import javax.sound.sampled.spi.MixerProvider;

import com.sun.media.sound.JDK13Services;

@SuppressWarnings("restriction")
public class MixerInfo {

	@SuppressWarnings({ "rawtypes" })
	public static void main(String[] args) throws UnsupportedEncodingException {
		List list = JDK13Services.getProviders(MixerProvider.class);
		for(Object object : list) {
			System.out.println(object.getClass().getName());
			for(Mixer.Info info : ((MixerProvider)object).getMixerInfo()) {
				System.out.println(info.getDescription());
			}
			System.out.println();
		}
	}
}
