# Chopsticks

[![Build Status](https://travis-ci.org/droibit/chopsticks.svg?branch=develop)](https://travis-ci.org/droibit/chopsticks) [![jitpack.io](https://jitpack.io/v/droibit/chopsticks.svg)](https://jitpack.io/#droibit/chopsticks) [![Software License](https://img.shields.io/badge/license-Apache%202.0-brightgreen.svg)](https://github.com/droibit/chopstics/blob/develop/LICENSE)

View, resource and preference injection library like [Kotter Knife](https://github.com/JakeWharton/kotterknife).

#### View, Resource

```kotlin
class BindViewActivity : AppCompatActivity() {

    private val textView: TextView by bindView(android.R.id.text1)
    private val button: Button by bindView(android.R.id.button1)
    private val toastMessage: String by bindString(R.string.toast_message)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bind_view)

        textView.text = "Hello, bindView"
        button.setOnClickListener {
            Toast.makeText(this@BindViewActivity, toastMessage, Toast.LENGTH_SHORT).show()
        }
    }
}
```

View injection to support the following classes.

* Activity
* SupportFragment
* ViewHolder
* View

And, it is also support unbind of view.

```kotlin
class BindViewFragment : Fragment(), Binder<Fragment> by SupportFragmentBinder() {

    private val textView: TextView by bindView(android.R.id.text1)
    private val button: Button by bindView(android.R.id.button1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_bind_view, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView.text = getString(R.string.bind_fragment_text)
        button.setOnClickListener {
            Toast.makeText(context, "Hello, bindView", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        unbindViews()
        super.onDestroyView()
    }
}
```

#### Preference

```kotlin
class SettingsFragment: PreferenceFragmentCompat() {

    // String resource is Preference key.
    private val checkboxPref: CheckBoxPreference by bindPreference(R.string.key_checkbox_preference)
    // String literal is Preference key.
    private val switchPref: SwitchPreference by bindPreference("switch_preference")

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.settings)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        checkboxPref.title = "Edited: ${checkboxPref.title}"
        switchPref.title = "Edited: ${switchPref.title}"
    }
}
```

Preference injection to support the following classes.

* PreferenceActivity
* PreferenceFragment
* PreferenceFragmentCompat(support-preference-v7)
* PreferenceFragment(support-preference-v14)

## Download

Add the following code to build.gradle.

```
repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
    compile "com.github.droibit.chopsticks:chopstick-view:0.7.0"
    compile "com.github.droibit.chopsticks:chopstick-resource:0.7.0"
    // If 'support-preference' is not required, to exclude 'preference-v7' and 'preference-v14'.
    compile "com.github.droibit.chopsticks:chopstick-preference:0.7.0"
}
```

This library is dependent on Kotlin 1.0.3.

## License

    Copyright (C) 2016 Shinya Kumagai

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
