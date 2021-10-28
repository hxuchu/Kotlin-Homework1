package com.example.kotlinguess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ed_name =findViewById<EditText>(R.id.ed_name)
        val tv_text =findViewById<TextView>(R.id.tv_text)
        val tv_name =findViewById<TextView>(R.id.tv_name)
        val tv_winner =findViewById<TextView>(R.id.tv_winner)
        val tv_mmora =findViewById<TextView>(R.id.tv_mmora)
        val tv_cmora =findViewById<TextView>(R.id.tv_cmora)
        val radioGroup =findViewById<RadioGroup>(R.id.radioGroup)
        val btn_scissor =findViewById<RadioButton>(R.id.btn_scissor)
        val btn_stone =findViewById<RadioButton>(R.id.btn_stone)
        val btn_papper =findViewById<RadioButton>(R.id.btn_papper)
        val btn_mora =findViewById<Button>(R.id.btn_mora)

        btn_mora.setOnClickListener(){
            if(ed_name.length()<1)
                tv_text.text="請輸入玩家姓名"
            else{
                //顯示名字
                tv_name.text="名字\n${ed_name.text}"
                //顯示我方出拳
                tv_mmora.text = "我方出拳\n${if(btn_scissor.isChecked)"剪刀"
                else if(btn_stone.isChecked)"石頭" else "布"}"
                //電腦出拳，亂數選擇0、1、2
                val computer = (Math.random()*3).toInt()
                //顯示電腦出拳
                tv_cmora.text = "電腦出拳\n${if(computer==0)"剪刀"
                else if(computer==1)"石頭" else "布"}"
                //三個判斷式判斷結果
                when{
                    btn_scissor.isChecked && computer==2 ||
                            btn_stone.isChecked && computer==0 ||
                            btn_papper.isChecked && computer==1 ->{
                        tv_winner.text = "勝利者\n${ed_name.text}"
                        tv_text.text = "你贏了好棒棒!!"
                    }
                    btn_scissor.isChecked && computer==1 ||
                            btn_stone.isChecked && computer==2 ||
                            btn_papper.isChecked && computer==0 ->{
                        tv_winner.text = "勝利者\n電腦"
                        tv_text.text = "你輸了幫哭哭"
                    }
                    else ->{
                        tv_winner.text = "勝利者\n平手"
                        tv_text.text = "平局，再來一次"
                    }
                }
            }
        }
    }
}