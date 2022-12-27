package com.rbn.gefragtgejagt

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


var quizdoktorAntwort: ImageView? = null
var bibliothekarAntwort: ImageView? = null
var besserwisserAntwort: ImageView? = null
var quizgottAntwort: ImageView? = null
var quizvulkanAntwort: ImageView? = null
var jaegerBeantwortung: Button? = null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quizdoktorAntwort = findViewById(R.id.quizdoktor_antwort)
        bibliothekarAntwort = findViewById<ImageView>(R.id.bibliothekar_antwort)
        besserwisserAntwort = findViewById<ImageView>(R.id.besserwisser_antwort)
        quizgottAntwort = findViewById<ImageView>(R.id.quizgott_antwort)
        quizvulkanAntwort = findViewById<ImageView>(R.id.quizvulkan_antwort)

        jaegerBeantwortung = findViewById(R.id.jaeger_beantwortung)

        //Erstellt onClickListener für den Button
        jaegerBeantwortung!!.setOnClickListener {

//            Toast.makeText(this, "Du hast auf den Button geklickt", Toast.LENGTH_LONG).show()
            /*quizdoktorAntwort!!.setImageResource(R.drawable.keine_antwort)
            Thread.sleep(100)
            bibliothekarAntwort!!.setImageResource(R.drawable.keine_antwort)
            Thread.sleep(100)
            besserwisserAntwort!!.setImageResource(R.drawable.keine_antwort)
            Thread.sleep(100)
            quizgottAntwort!!.setImageResource(R.drawable.keine_antwort)
            Thread.sleep(100)
            quizvulkanAntwort!!.setImageResource(R.drawable.keine_antwort)
            Thread.sleep(100)
            antwortJaeger()*/


            //val sharedPreferences = MyPreferences.getSharedPreferences(context)


            // Lade aktuelle Einstellungen und passe MainActivity entsprechend an
            val sharedPreferences = getSharedPreferences("settings", Context.MODE_PRIVATE)
            val animationCheck = sharedPreferences.getBoolean("switch1_status", false)
            val minOneJaeger = sharedPreferences.getBoolean("switch2_status", false)
            val exactOneJaeger = sharedPreferences.getBoolean("switch3_status", false)
            if (!animationCheck) {
                // Führe Aktion für Switch1 durch

                if (minOneJaeger) {
                    // Führe Aktion für Switch2 durch
                    minEinJaegerFalsch()
                } else if (!minOneJaeger && !exactOneJaeger) {

                    var zufallszahlQuizdoktor = (1..5).random()
                    var zufallszahlBibliothekar = (1..5).random()
                    var zufallszahlBesserwisser = (1..5).random()
                    var zufallszahlQuizgott = (1..5).random()
                    var zufallszahlQuizvulkan = (1..5).random()

                    if (zufallszahlQuizdoktor != 1) {
                        quizdoktorAntwort!!.setImageResource(R.drawable.richtig)
                    } else {
                        quizdoktorAntwort!!.setImageResource(R.drawable.falsch)
                    }

                    if (zufallszahlBibliothekar != 1) {
                        bibliothekarAntwort!!.setImageResource(R.drawable.richtig)
                    } else {
                        bibliothekarAntwort!!.setImageResource(R.drawable.falsch)
                    }

                    if (zufallszahlBesserwisser != 1) {
                        besserwisserAntwort!!.setImageResource(R.drawable.richtig)
                    } else {
                        besserwisserAntwort!!.setImageResource(R.drawable.falsch)
                    }

                    if (zufallszahlQuizgott != 1) {
                        quizgottAntwort!!.setImageResource(R.drawable.richtig)
                    } else {
                        quizgottAntwort!!.setImageResource(R.drawable.falsch)
                    }

                    if (zufallszahlQuizvulkan != 1) {
                        quizvulkanAntwort!!.setImageResource(R.drawable.richtig)
                    } else {
                        quizvulkanAntwort!!.setImageResource(R.drawable.falsch)
                    }
                } else if (exactOneJaeger) {
                    var zufallszahlJaeger = (1..5).random()
                    if (zufallszahlJaeger == 1) {
                        quizdoktorAntwort!!.setImageResource(R.drawable.falsch)
                    } else {
                        quizdoktorAntwort!!.setImageResource(R.drawable.richtig)
                    }
                    if (zufallszahlJaeger == 2) {
                        bibliothekarAntwort!!.setImageResource(R.drawable.falsch)
                    } else {
                        bibliothekarAntwort!!.setImageResource(R.drawable.richtig)
                    }
                    if (zufallszahlJaeger == 3) {
                        besserwisserAntwort!!.setImageResource(R.drawable.falsch)
                    } else {
                        besserwisserAntwort!!.setImageResource(R.drawable.richtig)
                    }
                    if (zufallszahlJaeger == 4) {
                        quizgottAntwort!!.setImageResource(R.drawable.falsch)
                    } else {
                        quizgottAntwort!!.setImageResource(R.drawable.richtig)
                    }
                    if (zufallszahlJaeger == 5) {
                        quizvulkanAntwort!!.setImageResource(R.drawable.falsch)
                    } else {
                        quizvulkanAntwort!!.setImageResource(R.drawable.richtig)
                    }
                }

            } else {
                Thread(Runnable {
                    updateImages()
                }).start()
            }


        }


    }

    fun minEinJaegerFalsch() {
        do {
            var zufallszahlQuizdoktor = (1..5).random()
            var zufallszahlBibliothekar = (1..5).random()
            var zufallszahlBesserwisser = (1..5).random()
            var zufallszahlQuizgott = (1..5).random()
            var zufallszahlQuizvulkan = (1..5).random()

            if (zufallszahlQuizdoktor != 1) {
                quizdoktorAntwort!!.setImageResource(R.drawable.richtig)
            } else {
                quizdoktorAntwort!!.setImageResource(R.drawable.falsch)
            }

            if (zufallszahlBibliothekar != 1) {
                bibliothekarAntwort!!.setImageResource(R.drawable.richtig)
            } else {
                bibliothekarAntwort!!.setImageResource(R.drawable.falsch)
            }

            if (zufallszahlBesserwisser != 1) {
                besserwisserAntwort!!.setImageResource(R.drawable.richtig)
            } else {
                besserwisserAntwort!!.setImageResource(R.drawable.falsch)
            }

            if (zufallszahlQuizgott != 1) {
                quizgottAntwort!!.setImageResource(R.drawable.richtig)
            } else {
                quizgottAntwort!!.setImageResource(R.drawable.falsch)
            }

            if (zufallszahlQuizvulkan != 1) {
                quizvulkanAntwort!!.setImageResource(R.drawable.richtig)
            } else {
                quizvulkanAntwort!!.setImageResource(R.drawable.falsch)
            }
        } while (zufallszahlQuizdoktor != 1 && zufallszahlBibliothekar != 1 && zufallszahlBesserwisser != 1 && zufallszahlQuizgott != 1 && zufallszahlQuizvulkan != 1)

    }

    fun updateImages() {


        jaegerBeantwortung!!.isClickable = false
        val sharedPreferences = getSharedPreferences("settings", Context.MODE_PRIVATE)
        if (sharedPreferences.getBoolean("switch3_status", false)) {
            for (i in 10 downTo 2) {
                var zufallszahlJaeger = (1..5).random()
                quizdoktorAntwort!!.setImageResource(R.drawable.keine_antwort)
                Thread.sleep(10 * i.toLong())
                bibliothekarAntwort!!.setImageResource(R.drawable.keine_antwort)
                Thread.sleep(10 * i.toLong())
                besserwisserAntwort!!.setImageResource(R.drawable.keine_antwort)
                Thread.sleep(10 * i.toLong())
                quizgottAntwort!!.setImageResource(R.drawable.keine_antwort)
                Thread.sleep(10 * i.toLong())
                quizvulkanAntwort!!.setImageResource(R.drawable.keine_antwort)
                Thread.sleep(10 * i.toLong())
                if (zufallszahlJaeger == 1) {
                    quizdoktorAntwort!!.setImageResource(R.drawable.falsch)
                } else {
                    quizdoktorAntwort!!.setImageResource(R.drawable.richtig)
                }
                Thread.sleep(10 * i.toLong())
                if (zufallszahlJaeger == 2) {
                    bibliothekarAntwort!!.setImageResource(R.drawable.falsch)
                } else {
                    bibliothekarAntwort!!.setImageResource(R.drawable.richtig)
                }
                Thread.sleep(10 * i.toLong())
                if (zufallszahlJaeger == 3) {
                    besserwisserAntwort!!.setImageResource(R.drawable.falsch)
                } else {
                    besserwisserAntwort!!.setImageResource(R.drawable.richtig)
                }
                Thread.sleep(10 * i.toLong())
                if (zufallszahlJaeger == 4) {
                    quizgottAntwort!!.setImageResource(R.drawable.falsch)
                } else {
                    quizgottAntwort!!.setImageResource(R.drawable.richtig)
                }
                Thread.sleep(10 * i.toLong())
                if (zufallszahlJaeger == 5) {
                    quizvulkanAntwort!!.setImageResource(R.drawable.falsch)
                } else {
                    quizvulkanAntwort!!.setImageResource(R.drawable.richtig)
                }
                Thread.sleep(10 * i.toLong())
            }
            jaegerBeantwortung!!.isClickable = true
        }
        else{

            for (i in 10 downTo 2) {
                quizdoktorAntwort!!.setImageResource(R.drawable.keine_antwort)
                Thread.sleep(10 * i.toLong())
                bibliothekarAntwort!!.setImageResource(R.drawable.keine_antwort)
                Thread.sleep(10 * i.toLong())
                besserwisserAntwort!!.setImageResource(R.drawable.keine_antwort)
                Thread.sleep(10 * i.toLong())
                quizgottAntwort!!.setImageResource(R.drawable.keine_antwort)
                Thread.sleep(10 * i.toLong())
                quizvulkanAntwort!!.setImageResource(R.drawable.keine_antwort)
                Thread.sleep(10 * i.toLong())

                antwortJaeger(10 * i.toLong())
            }
            jaegerBeantwortung!!.isClickable = true
        }
    }

    private fun antwortJaeger(wartezeit: Long) {

        //Erstellt eine Zufallszahl zwischen 1 und einschließlich 5
        var zufallszahlQuizdoktor = (1..5).random()
        var zufallszahlBibliothekar = (1..5).random()
        var zufallszahlBesserwisser = (1..5).random()
        var zufallszahlQuizgott = (1..5).random()
        var zufallszahlQuizvulkan = (1..5).random()

        Thread.sleep(wartezeit)
        if (zufallszahlQuizdoktor != 1) {
            quizdoktorAntwort!!.setImageResource(R.drawable.richtig)
        } else {
            quizdoktorAntwort!!.setImageResource(R.drawable.falsch)
        }
        Thread.sleep(wartezeit)

        if (zufallszahlBibliothekar != 1) {
            bibliothekarAntwort!!.setImageResource(R.drawable.richtig)
        } else {
            bibliothekarAntwort!!.setImageResource(R.drawable.falsch)
        }
        Thread.sleep(wartezeit)

        if (zufallszahlBesserwisser != 1) {
            besserwisserAntwort!!.setImageResource(R.drawable.richtig)
        } else {
            besserwisserAntwort!!.setImageResource(R.drawable.falsch)
        }
        Thread.sleep(wartezeit)

        if (zufallszahlQuizgott != 1) {
            quizgottAntwort!!.setImageResource(R.drawable.richtig)
        } else {
            quizgottAntwort!!.setImageResource(R.drawable.falsch)
        }
        Thread.sleep(wartezeit)

        if (zufallszahlQuizvulkan != 1) {
            quizvulkanAntwort!!.setImageResource(R.drawable.richtig)
        } else {
            quizvulkanAntwort!!.setImageResource(R.drawable.falsch)
        }

        val sharedPreferences = getSharedPreferences("settings", Context.MODE_PRIVATE)

        if (sharedPreferences.getBoolean("switch2_status", false)) {
            minEinJaegerFalsch()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_overflow, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_appinfo -> {
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                intent.data = Uri.parse("package:$packageName")
                startActivity(intent)
                return true
            }
            R.id.action_settings -> {


                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
                /*val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(getString(R.string.url_fdroid))
                startActivity(intent)*/
                return true
            }
            R.id.action_github -> {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(getString(R.string.url_github))
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }


    /*override fun onMenuItemSelected(featureId: Int, item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_appinfo) {
            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
            intent.data = Uri.parse("package:$packageName")
            startActivity(intent)
        } else if (id == R.id.action_settings) {
            *//*val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(getString(R.string.url_fdroid))
            startActivity(intent)*//*
        }else if (id == R.id.action_github) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(getString(R.string.url_github))
            startActivity(intent)
        }
        return super.onMenuItemSelected(featureId, item)
    }*/


}