package com.example.bt10sqlite.Control;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.opengl.Visibility;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bt10sqlite.ListSinhVien;
import com.example.bt10sqlite.MainActivity;
import com.example.bt10sqlite.Model.SinhVien;
import com.example.bt10sqlite.R;

import java.util.ArrayList;
import java.util.List;

public class SinhVienAdapter extends RecyclerView.Adapter<SinhVienAdapter.ViewHolder> {
    //Dữ liệu hiện thị là danh sách sinh viên
    private List<SinhVien> mSinhVien;
    // Lưu Context để dễ dàng truy cập
    private Context mContext;

    public SinhVienAdapter(List<SinhVien> SinhViens, Context mContext) {
        this.mSinhVien = SinhViens;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public SinhVienAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_SinhVienitem, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SinhVienAdapter.ViewHolder holder, int position) {
        SinhVien SinhVien = mSinhVien.get(position);
        holder.studentname.setText(SinhVien.getIdSinhVien());
    }
}