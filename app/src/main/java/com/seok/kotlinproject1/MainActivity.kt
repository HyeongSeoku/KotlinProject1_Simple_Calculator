package com.seok.kotlinproject1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View

import android.widget.Toast
import com.seok.kotlinproject1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    var command : String? = null        //버튼 클릭시 연산자 담을 변수
    var firstN : Int = 0
    var secondN : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // getRoot 메서드로 레이아웃 내부의 최상위 위치 뷰의
        // 인스턴스를 활용하여 생성된 뷰를 액티비티에 표시 합니다.
        setContentView(binding.root);

        //binding.id 값 : 타입 값


        binding.plusBtn.setOnClickListener(this)
        binding.minusBtn.setOnClickListener(this)
        binding.multiplyBtn.setOnClickListener(this)
        binding.divisionBtn.setOnClickListener(this)
        binding.resultBtn.setOnClickListener(this)


        if (!command.equals(null))Toast.makeText(this@MainActivity,"Command 값 : ${command} ",Toast.LENGTH_LONG).show()
        else Toast.makeText(this@MainActivity,"Command 값을 입력해주세요 ! ",Toast.LENGTH_LONG).show()
        var firN : String =binding.firstNum.text.toString()
        var secN : String =binding.secondNum.text.toString()
        Log.d("FirsetN","값 : $firN")
        Log.d("SecondN","값 : $secN")

    }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.plusBtn.id -> {
                command = "+"
                firstN = Integer.parseInt(binding.firstNum.text.toString())
                secondN =Integer.parseInt(binding.secondNum.text.toString())
            }
            binding.minusBtn.id ->{
                command = "-"
                firstN = Integer.parseInt(binding.firstNum.text.toString())
                secondN =Integer.parseInt(binding.secondNum.text.toString())
            }
            binding.multiplyBtn.id ->{
                command = "*"
                firstN = Integer.parseInt(binding.firstNum.text.toString())
                secondN =Integer.parseInt(binding.secondNum.text.toString())
            }
            binding.divisionBtn.id -> {
                command = "/"
                firstN = Integer.parseInt(binding.firstNum.text.toString())
                secondN =Integer.parseInt(binding.secondNum.text.toString())
            }
            binding.resultBtn.id -> binding.resultNum.text = calculate(firstN,secondN,command)
        }
        Log.d("CommandBtn","Command 값 :${command}")
    }

    fun calculate(num1:Int,num2:Int, command:String?):String{
        var sum :Int = 0;
        var result : String ="";
        if(num1==0) {
            Toast.makeText(this," 첫번째 값이 입력되지 않았습니다 ",Toast.LENGTH_LONG).show()
            Log.d("calculate","첫번째 값이 입력되지 않았습니다 $num1")
        }else if( num2 == 0 ){
            Toast.makeText(this," 두번째 값이 입력되지 않았습니다 ",Toast.LENGTH_LONG).show()
            Log.d("calculate","두번째 값이 입력되지 않았습니다 $num2")
        }else if(command.equals(null)){
            Toast.makeText(this," 연사자 값이 입력되지 않았습니다 ",Toast.LENGTH_LONG).show()
            Log.d("calculate","연산자 값이 입력되지 않았습니다 $command")
        }
        else{
            when(command){
                "+" ->sum = num1 + num2
                "-" -> sum = num1 - num2
                "*" -> sum = num1 * num2
                "/" -> sum = num1 / num2
            }
            result = sum.toString()
        }
        return result
    }

}