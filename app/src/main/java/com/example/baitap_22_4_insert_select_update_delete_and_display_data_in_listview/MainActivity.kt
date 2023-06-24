package com.example.baitap_22_4_insert_select_update_delete_and_display_data_in_listview

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import com.example.baitap_22_4_insert_select_update_delete_and_display_data_in_listview.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    lateinit var db :SQLiteDatabase
    lateinit var rs : Cursor
    lateinit var adapter: SimpleCursorAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var helper = myHelper(applicationContext)
        db = helper.readableDatabase
        rs = db.rawQuery("SELECT * FROM TUHOC LIMIT 20",null)
        //sql : String chuổi câu lệnh SQL
        // String[]selectionArgs : chọn lộc dữ liệu với diều kiện mảng
        //1. đưa dữ liệu của dòng đầu tiên trogn db lên edtuser va edtemail
        if(rs.moveToLast()){
            binding.edtUser.setText(rs.getString(1))
            binding.edtEmail.setText(rs.getString(2))
        }
        //2.code btnfirst
        binding.btnfirst.setOnClickListener {
            if (rs.moveToFirst()){
                binding.edtUser.setText(rs.getString(1))
                binding.edtEmail.setText(rs.getString(2))
            }
            else
                Toast.makeText(applicationContext,"No Data found",Toast.LENGTH_SHORT).show()
        }
        //3.code nut next
        binding.btnnext.setOnClickListener {
            if(rs.moveToNext()){
                binding.edtUser.setText(rs.getString(1))
                binding.edtEmail.setText(rs.getString(2))
            }
            else if(rs.moveToFirst()){
                binding.edtUser.setText(rs.getString(1))
                binding.edtEmail.setText(rs.getString(2))
            }

            else
                Toast.makeText(applicationContext,"No Data found",Toast.LENGTH_SHORT).show()
        }
        //4.code cho prev
        binding.btnprev.setOnClickListener {
            if(rs.moveToPrevious()){
                binding.edtUser.setText(rs.getString(1))
                binding.edtEmail.setText(rs.getString(2))
            }
            else if(rs.moveToLast()){
                binding.edtUser.setText(rs.getString(1))
                binding.edtEmail.setText(rs.getString(2))
            }
            else
                Toast.makeText(applicationContext,"No Data found",Toast.LENGTH_SHORT).show()
        }
        //5.code btnlast
        binding.btnlast.setOnClickListener {
            if (rs.moveToLast()){
                binding.edtUser.setText(rs.getString(1))
                binding.edtEmail.setText(rs.getString(2))
            }
            else
                Toast.makeText(applicationContext,"No Data found",Toast.LENGTH_SHORT).show()
        }
        // 6 code phàn lvfull
        adapter = SimpleCursorAdapter(
            applicationContext,android.R.layout.simple_expandable_list_item_2,rs,
            arrayOf("user","email"), intArrayOf(android.R.id.text1,android.R.id.text2),0
        )
        binding.lvFull.adapter = adapter
        //7.code cho nut viewall
//        binding.btnVIEWALL.setOnClickListener {
//            binding.svserview.visibility = View.VISIBLE
//            binding.lvFull.visibility = View.VISIBLE
//            adapter.notifyDataSetChanged()
//            binding.svserview.queryHint"tìm kiếm trong${rs.count} bản ghi"
//        }
    }
}