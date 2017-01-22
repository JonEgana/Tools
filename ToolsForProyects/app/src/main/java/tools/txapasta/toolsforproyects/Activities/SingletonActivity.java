package tools.txapasta.toolsforproyects.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import tools.txapasta.toolsforproyects.Helper.SingletonSession;
import tools.txapasta.toolsforproyects.R;

/*
*
* 1-Ocultar el constructor de la clase Singleton, para que los clientes no puedan crear instancias.
* 2-Declarar en la clase Singleton una variable miembro privada que contenga la referencia a la instancia única que queremos gestionar.
* 3-Proveer en la clase Singleton una función o propiedad que brinde acceso a la única instancia gestionada por el Singleton. Los clientes acceden a la instancia a través de esta función o propiedad.
* */
public class SingletonActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et_username,et_password;
    TextView tv_info;
    Button btn_login,btn_next;
    LinearLayout ll_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleton);
        findViewsById();

        btn_login.setOnClickListener(this);
        btn_next.setOnClickListener(this);
    }

    private void findViewsById(){
        ll_info = (LinearLayout)findViewById(R.id.ll_info);

        et_username = (EditText)findViewById(R.id.et_username);
        et_password = (EditText)findViewById(R.id.et_password);

        tv_info = (TextView) findViewById(R.id.tv_info);

        btn_next = (Button)findViewById(R.id.btn_next);
        btn_login = (Button) findViewById(R.id.btn_login);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                SingletonSession.getInstance().setUsername(et_username.getText().toString());
                SingletonSession.getInstance().setUserpassword(et_password.getText().toString());
               showInformation();
                break;
            case R.id.btn_next:
                startActivity(new Intent(SingletonActivity.this,FragmentsActivity.class));
                finish();
                break;
        }
    }

    private void showInformation(){
        ll_info.setVisibility(View.VISIBLE);
        tv_info.setText(SingletonSession.getInstance().getUsername()+"/"+SingletonSession.getInstance().getUserpassword());
    }
}
