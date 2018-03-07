package sin.glouds.test.pref;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class PreferenceTest {

	public static void main(String[] args) throws BackingStoreException {
		Preferences preferences = Preferences.systemRoot();
		System.out.println(preferences.name());
		System.out.println(preferences.isUserNode());
		System.out.println(preferences.childrenNames());
	}
}
