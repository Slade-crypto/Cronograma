package renansander.cronogramanovo;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import renansander.cronogramanovo.adapters.ProfessorAdapter;
import renansander.cronogramanovo.models.ProfessorModel;

public class ListaProfessoresActivity extends AppCompatActivity {

    String url = "https://64773f3c9233e82dd53b4128.mockapi.io/professores";
    ArrayList<ProfessorModel> professores;
    RecyclerView rcvMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_professores);

        rcvMain = findViewById(R.id.rcvMain);
        rcvMain.setLayoutManager(new LinearLayoutManager(this));
        professores = new ArrayList<>();
        getMaterias();

    }

    private void getMaterias() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);


        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject jsonObject = array.getJSONObject(i);

                                ProfessorModel professor = new ProfessorModel(
                                        jsonObject.getString("id"),
                                        jsonObject.getString("nomeProfessor"),
                                        jsonObject.getString("descricaoProfessor"),
                                        jsonObject.getString("imageProfessor")
                                );
                                professores.add(professor);
                            }

                            rcvMain.setAdapter(new ProfessorAdapter(ListaProfessoresActivity.this, professores));

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("API", "onReponse" + e.getMessage());
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("API", "errorReponse" + error.getLocalizedMessage());
            }
        });
        queue.add(stringRequest);
    }
}