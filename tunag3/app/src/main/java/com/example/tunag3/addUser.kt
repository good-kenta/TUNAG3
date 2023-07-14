package com.example.tunag3

import android.graphics.Color
import android.graphics.drawable.DrawableContainer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.tunag3.databinding.ActivityAddUserBinding
import com.google.android.material.snackbar.Snackbar
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where

class AddUser : AppCompatActivity() {

    private lateinit var realm : Realm//8)realm変数用意

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)

        //4)viewの取得
        val addUserName: EditText = findViewById(R.id.addUserName)
        val userTelText: EditText = findViewById(R.id.userTelText)
        val userMailText: EditText = findViewById(R.id.userMailText)
        val userPassText: EditText = findViewById(R.id.userPassText)
        val addUserButton: Button = findViewById(R.id.addUserButton)

        //8)realmインスタンス用意
        realm = Realm.getDefaultInstance()

        //9)addUserButton押したら
        addUserButton.setOnClickListener{
            //  上書き用の変数用意
            var name : String =""
            //10)入力された文字が空文字でなければ～
            if (addUserName.text.isNullOrEmpty()){
                name = addUserName.toString()
            }
            //11)DBに書き込み（Transaction{}）
            realm.executeTransaction{
                val currentId = realm.where<Users>().max("id")//現時点のidの最高値を取得
                //最高値に１を追加（０なら１に）←行を追加するイメージ
                val nextId = (currentId?.toLong()?:0L)+1L

                //モデルクラスnextId番目に値をセット
                val addUser = realm.createObject<Users>(nextId)
                addUser.name = name
            }
            Toast.makeText(applicationContext,"保存しました",Toast.LENGTH_SHORT).show()
            finish()
        }

    }
    //8)realm閉じる
    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}