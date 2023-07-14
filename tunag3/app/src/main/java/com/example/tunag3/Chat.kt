package com.example.tunag3

import android.content.Intent
import android.graphics.drawable.DrawableContainer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.tunag3.databinding.ActivityChatBinding
import io.realm.Realm

class Chat : AppCompatActivity() {
    private lateinit var realm: Realm//7)realmの変数用意

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        //1)Viewの設定
        val tvName: TextView = findViewById(R.id.tvName)
        val btnShow: Button = findViewById(R.id.btnShow)
        val btnAdd: Button = findViewById(R.id.btnAdd)
        realm = Realm.getDefaultInstance()//7)realmのインスタンス

        //6)btnaddを押したらintent
        btnAdd.setOnClickListener {
            val intent = Intent(this, AddUser::class.java)
            startActivity(intent)
            tvName.text = "Name" //１４）tvNameが毎度連なるのでリセット
        }
        //13)表示します
        btnShow.setOnClickListener {
            //realmに記載されている全件数探す
            //TextViewに表示させたいのでListに入れます
            val realmResults: List<Users> = realm.where(Users::class.java).findAll()

            //for文で繰り返し表示
            //for(変数 in データ量){繰り返す処理}
            for (i in realmResults.indices) {
                //tvName.text
                tvName.append("\n") //改行
                tvName.append(realmResults[i].name) //文字を連結して表示
            }
        }
    }
        //realmを閉じる
        override fun onDestroy() {
            super.onDestroy()
            realm.close()
        }
    }

