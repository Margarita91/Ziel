package zielabi.icon_worldwide.com.zielabi;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * Created by margarita on 23/08/2017.
 */
public class ZielABIPreferences implements SharedPreferences {

    private final static String TAG = ZielABIPreferences.class
            .getSimpleName();

    // TODO: errori depqum =>  Preferences > Editor > Code Style > Formatter Control  ;)
    //@formatter:off
    public static enum Settings {
        DIALOG_SHOWED("DIALOG_SHOWED", Boolean.class),

        IS_FIRST_LAUNCH("IS_FIRST_LAUNCH", Boolean.class);


        private final String key;
        private final Class<?> type;

        private Settings(final String key, final Class<?> type) {
            this.key = key;
            this.type = type;
        }

        public String key() {
            return this.key;
        }

        Class<?> type() {
            return this.type;
        }
    }

    //@formatter:on
    private static ZielABIPreferences settingsObject = null;
    private static SharedPreferences sPreferences = null;
    private final static String PREF_FILENAME = "ZielABIPreferences";

    private ZielABIPreferences(final Context context) {
        try {
            sPreferences = context.getSharedPreferences(PREF_FILENAME,
                    Context.MODE_PRIVATE);

            if (!contains(Settings.IS_FIRST_LAUNCH)) {
                setSetting(Settings.IS_FIRST_LAUNCH, true);
            }
        } catch (final Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    public static synchronized ZielABIPreferences getAppSettings() {
        if (null == settingsObject) {
            settingsObject = new ZielABIPreferences(ZielAbiApplication.getContext());
        }

        return settingsObject;
    }

    public boolean contains(final Settings settingsKey) {
        return contains(settingsKey.key());
    }

    @Override
    public boolean contains(final String key) {
        boolean retval = false;

        if (null != sPreferences) {
            retval = sPreferences.contains(key);
        }

        return retval;
    }

    public synchronized void setSetting(final Settings settingsKey,
                                        final Object value) throws ClassCastException {

        final Editor settingsEditor = edit();
        boolean bChanged = false;
        final String key = settingsKey.key();
        final Class<?> type = settingsKey.type();

        if (null != settingsEditor) {
            if (String.class == type) {
                settingsEditor.putString(key, (String) value);
                bChanged = true;
            } else if (Boolean.class == type) {
                settingsEditor.putBoolean(key, (Boolean) value);
                bChanged = true;
            } else if (Integer.class == type) {
                settingsEditor.putInt(key, (Integer) value);
                bChanged = true;
            } else if (Long.class == type) {
                settingsEditor.putLong(key, (Long) value);
                bChanged = true;
            } else if (Float.class == type) {
                settingsEditor.putFloat(key, (Float) value);
                bChanged = true;
            }

            if (bChanged) {
                settingsEditor.commit();
            }
        }
    }

    @Override
    public Editor edit() {
        Editor editor = null;

        if (null != sPreferences) {
            editor = sPreferences.edit();
        }

        return editor;
    }

    @Override
    public Map<String, ?> getAll() {
        Map<String, ?> map = Collections.emptyMap();

        if (null != sPreferences) {
            map = sPreferences.getAll();
        }

        return map;
    }

    public boolean getBoolean(final Settings settingsKey)
            throws ClassCastException {
        return getBoolean(settingsKey.key(), false);
    }

    @Override
    public boolean getBoolean(final String key, final boolean defValue) {
        boolean retval = defValue;

        if (null != sPreferences) {
            retval = sPreferences.getBoolean(key, defValue);
        }

        return retval;
    }

    public float getFloat(final Settings settingsKey) throws ClassCastException {
        return getFloat(settingsKey.key(), 0);
    }

    @Override
    public float getFloat(final String key, final float defValue) {
        float retval = defValue;

        if (null != sPreferences) {
            retval = sPreferences.getFloat(key, defValue);
        }

        return retval;
    }

    public int getInt(final Settings settingsKey) throws ClassCastException {
        return getInt(settingsKey.key(), -1);
    }

    @Override
    public int getInt(final String key, final int defValue) {
        int retval = defValue;

        if (null != sPreferences) {
            retval = sPreferences.getInt(key, defValue);
        }

        return retval;
    }

    public long getLong(final Settings settingsKey) throws ClassCastException {
        return getLong(settingsKey.key(), -1);
    }

    @Override
    public long getLong(final String key, final long defValue) {
        long retval = defValue;

        if (null != sPreferences) {
            retval = sPreferences.getLong(key, defValue);
        }

        return retval;
    }

    public String getString(final Settings settingsKey)
            throws ClassCastException {
        return getString(settingsKey.key(), null);
    }

    @Override
    public String getString(final String key, final String defValue) {
        String retval = defValue;

        if (null != sPreferences) {
            retval = sPreferences.getString(key, defValue);
        }

        return retval;
    }

    @Override
    public void registerOnSharedPreferenceChangeListener(
            final OnSharedPreferenceChangeListener listener) {

        if (null != sPreferences) {
            sPreferences.registerOnSharedPreferenceChangeListener(listener);
        }
    }

    @Override
    public void unregisterOnSharedPreferenceChangeListener(
            final OnSharedPreferenceChangeListener listener) {

        if (null != sPreferences) {
            sPreferences.unregisterOnSharedPreferenceChangeListener(listener);
        }
    }

    @Override
    public Set<String> getStringSet(String key, Set<String> defValue) {
        Set<String> retval = defValue;

        if (null != sPreferences) {
            retval = sPreferences.getStringSet(key, defValue);
        }

        return retval;
    }

}