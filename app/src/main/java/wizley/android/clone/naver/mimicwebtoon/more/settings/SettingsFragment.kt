package wizley.android.clone.naver.mimicwebtoon.more.settings

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceFragment
import android.util.Log
import androidx.preference.CheckBoxPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.rv_webtoon.*
import wizley.android.clone.naver.mimicwebtoon.R
import wizley.android.clone.naver.mimicwebtoon.more.notice.NoticeActivity
import wizley.android.clone.naver.mimicwebtoon.more.settings.autoplay.AutoplaySettingsActivity

class SettingsFragment(private val resource: Int): PreferenceFragmentCompat(), SharedPreferences.OnSharedPreferenceChangeListener,
    Preference.OnPreferenceChangeListener {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(resource, rootKey)

        preferenceScreen.sharedPreferences.registerOnSharedPreferenceChangeListener(this)
        initCheckPreference()
    }

    override fun onStart() {
        super.onStart()

        setSummary()
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        when(key) {

        }
    }

    override fun onPreferenceTreeClick(preference: Preference?): Boolean {
        when(preference?.key){
            "autoplay" -> {
                val intent = Intent(activity, AutoplaySettingsActivity::class.java)
                startActivity(intent)
            }
            "notice" -> {
                val intent = Intent(activity, NoticeActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onPreferenceTreeClick(preference)
    }

    override fun onPreferenceChange(preference: Preference?, newValue: Any?): Boolean {
        if(newValue == false) return false
        when(preference?.key){
            "always" -> {
                preferenceManager.findPreference<CheckBoxPreference>("wifi")?.isChecked = false
                preferenceManager.findPreference<CheckBoxPreference>("disable")?.isChecked = false
            }
            "wifi" -> {
                preferenceManager.findPreference<CheckBoxPreference>("always")?.isChecked = false
                preferenceManager.findPreference<CheckBoxPreference>("disable")?.isChecked = false
            }
            "disable" -> {
                preferenceManager.findPreference<CheckBoxPreference>("always")?.isChecked = false
                preferenceManager.findPreference<CheckBoxPreference>("wifi")?.isChecked = false
            }
        }
        return true
    }

    private fun initCheckPreference(){
        preferenceManager.findPreference<CheckBoxPreference>("always")?.onPreferenceChangeListener = this
        preferenceManager.findPreference<CheckBoxPreference>("wifi")?.onPreferenceChangeListener = this
        preferenceManager.findPreference<CheckBoxPreference>("disable")?.onPreferenceChangeListener = this
    }

    private fun setSummary(){
        val sps = PreferenceManager.getDefaultSharedPreferences(activity)

        when {
            sps.getBoolean("always", false) -> {
                preferenceManager.findPreference<Preference>("autoplay")?.summary = "항상 켜기"
            }
            sps.getBoolean("wifi", false) -> {
                preferenceManager.findPreference<Preference>("autoplay")?.summary = "Wi-Fi에서만"
            }
            else -> {
                preferenceManager.findPreference<Preference>("autoplay")?.summary = "항상 끄기"
            }
        }
    }
}
