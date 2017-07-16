package com.eyad.alkronz.employeeproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eyad.alkronz.employeeproject.Entity.Employee;
import com.eyad.alkronz.employeeproject.Entity.FullTimeEmployee;
import com.eyad.alkronz.employeeproject.Entity.PartTimeEmployee;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Employee>employees = new ArrayList<>();
         employees.add(new FullTimeEmployee(1 , "eyad" , 21 , R.drawable.emp1 , 2500));
        employees.add(new PartTimeEmployee(1 , "Aseal" , 22 ,  R.drawable.emp10 , 12));
        employees.add(new FullTimeEmployee(1 , "ali" , 22 , R.drawable.img3 , 3000));
        employees.add(new PartTimeEmployee(1 , "Alaa" , 21 ,  R.drawable.img4 , 14));
        employees.add(new FullTimeEmployee(1 , "osama" , 36 , R.drawable.img5 , 1500));
        employees.add(new PartTimeEmployee(1 , "may" , 32 ,  R.drawable.emp10 , 18));
        employees.add(new FullTimeEmployee(1 , "ziad" , 27 , R.drawable.img7 , 2000));
        employees.add(new PartTimeEmployee(1 , "yasmen" , 28 ,  R.drawable.img8 , 17));
        employees.add(new FullTimeEmployee(1 , "Ibrahim" , 20 , R.drawable.img9 , 1900));
        employees.add(new PartTimeEmployee(1 , "Mariam" , 25 ,  R.drawable.img8 , 10));




        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.setAdapter(new DifferentRowAdapter(employees));


    }


    class DifferentRowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        List<Employee>employees ;

        public DifferentRowAdapter( List<Employee>employees ) {
            this.employees = employees;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;

            switch (viewType) {
                case 0:
                    view = LayoutInflater.from(parent.getContext()).inflate(R.layout.full_employee_row, parent, false);
                    return new FullTimeEmployeeHolderHolder(view);
                case 1:
                    view = LayoutInflater.from(parent.getContext()).inflate(R.layout.part_employee_row2, parent, false);
                    return new PartTimeEmployeeHolderHolder(view);
            }
            return null;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Employee object = employees.get(position);
            if (object != null) {
               if(object instanceof FullTimeEmployee){

                   ((FullTimeEmployeeHolderHolder) holder).name_emp.setText(((FullTimeEmployee)object).getName());
                   ((FullTimeEmployeeHolderHolder) holder).age_emp.setText(((FullTimeEmployee)object).getAge()+"");
                   ((FullTimeEmployeeHolderHolder) holder).id_emp.setText(((FullTimeEmployee)object).getId()+"");
                   ((FullTimeEmployeeHolderHolder) holder).salaryMonth.setText(((FullTimeEmployee)object).getMonthSalary()+"");
                   ((FullTimeEmployeeHolderHolder) holder).image_emp.setImageResource(((FullTimeEmployee)object).getImageid());
               }
                else if (object instanceof PartTimeEmployee){
                   ((PartTimeEmployeeHolderHolder) holder).name_emp.setText(((PartTimeEmployee)object).getName());
                   ((PartTimeEmployeeHolderHolder) holder).age_emp.setText(((PartTimeEmployee)object).getAge()+"");
                   ((PartTimeEmployeeHolderHolder) holder).id_emp.setText(((PartTimeEmployee)object).getId()+"");
                   ((PartTimeEmployeeHolderHolder) holder).salaryHour.setText(((PartTimeEmployee)object).getHourFee()+"");
                   ((PartTimeEmployeeHolderHolder) holder).image_emp.setImageResource(((PartTimeEmployee)object).getImageid());
                 }


            }//id != null
        }

        @Override
        public int getItemCount() {
            if (employees == null)
                return 0;
            return employees.size();
        }

        @Override
        public int getItemViewType(int position) {
            if (employees != null) {
                Employee object = employees.get(position);
                if (object instanceof FullTimeEmployee ) {
                    return 0;
                }
                else  if (object instanceof PartTimeEmployee ) {
                    return 1;
                }
            }
            return 0;
        }


        public   class FullTimeEmployeeHolderHolder extends RecyclerView.ViewHolder {
            private TextView id_emp;
            private TextView name_emp;
             private TextView age_emp;
            private TextView salaryMonth;
            private ImageView image_emp;

            public FullTimeEmployeeHolderHolder(View itemView) {
                super(itemView);
                id_emp = (TextView) itemView.findViewById(R.id.id_emp);
                name_emp = (TextView) itemView.findViewById(R.id.name_emp);
                age_emp = (TextView) itemView.findViewById(R.id.age_emp);
                salaryMonth = (TextView) itemView.findViewById(R.id.salaryMonth);
                image_emp = (ImageView) itemView.findViewById(R.id.image_emp);
            }
        }

        public   class PartTimeEmployeeHolderHolder extends RecyclerView.ViewHolder {
            private TextView id_emp;
            private TextView name_emp;
             private TextView age_emp;
            private TextView salaryHour;
            private ImageView image_emp;

            public PartTimeEmployeeHolderHolder(View itemView) {
                super(itemView);
                id_emp = (TextView) itemView.findViewById(R.id.id_emp);
                name_emp = (TextView) itemView.findViewById(R.id.name_emp);
                age_emp = (TextView) itemView.findViewById(R.id.age_emp);
                salaryHour = (TextView) itemView.findViewById(R.id.salaryHour);
                image_emp = (ImageView) itemView.findViewById(R.id.image_emp);
            }
        }
    }









}
