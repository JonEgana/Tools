package tools.txapasta.toolsforproyects.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import tools.txapasta.toolsforproyects.Fragments.ComicDetailsFragment;
import tools.txapasta.toolsforproyects.Fragments.ComicListFragment;
import tools.txapasta.toolsforproyects.R;

public class FragmentsActivity extends AppCompatActivity implements ComicListFragment.OnComicSelected, View.OnClickListener {

    private Button btn_json_example;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);
        btn_json_example = (Button)findViewById(R.id.btn_json_example);
        btn_json_example.setOnClickListener(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.root_layout, ComicListFragment.newInstance(), "rageComicList")
                    .commit();
        }
    }

    @Override
    public void onComicSelected(int imageResId, String name, String description, String url) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.root_layout, ComicDetailsFragment.newInstance(imageResId, name, description, url), "ComicDetails")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_json_example:
                startActivity(new Intent(FragmentsActivity.this,JsonExampleActivity.class));
                finish();
                break;
        }
    }
}
