package com.example.sidnei.apppedido;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    JSONObject jsonobject;
    JSONArray jsonarray;
    ProgressDialog mProgressDialog;
    ArrayList<String> worldlist;
    ArrayList<WorldPopulation> world;

    ArrayList<String> itemlist;
    ArrayList<Produto> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Download JSON file AsyncTask
        new DownloadJSON().execute();
    }

    // Download JSON file AsyncTask
    private class DownloadJSON extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            // Locate the WorldPopulation Class
            world = new ArrayList<WorldPopulation>();
            item = new ArrayList<Produto>();
            // Create an array to populate the spinner
            worldlist = new ArrayList<String>();
            itemlist = new ArrayList<String>();


            // JSON file URL address
            //jsonobject = JSONfunctions.getJSONfromURL("http://www.androidbegin.com/tutorial/jsonparsetutorial.txt");
            jsonobject = JSONfunctions.getJSONfromURL("http://10.0.2.2:81/ws_sgestao/Json/ProdutoWS.json");

            try {
                // Locate the NodeList name
                jsonarray = jsonobject.getJSONArray("produtos");
                for (int i = 0; i < jsonarray.length(); i++) {
                    jsonobject = jsonarray.getJSONObject(i);

                    Produto prod = new Produto();

                    prod.set_id(jsonobject.optInt("idproduto"));
                    prod.setProdutoDescricao(jsonobject.optString("produtodescricao"));
                    prod.setProdutoPrecovenda(jsonobject.optDouble("produtoprecovenda"));
                    prod.setProdutoPrecoCusto(jsonobject.optDouble("produtoprecocusto"));
                    item.add(prod);

                    // Populate spinner with country names
                    worldlist.add(jsonobject.optString("idproduto")+ "- " + jsonobject.optString("produtodescricao"));

                }
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void args) {
            // Locate the spinner in activity_main.xml
            Spinner mySpinner = (Spinner) findViewById(R.id.my_spinner);

            // Spinner adapter
            mySpinner.setAdapter(new ArrayAdapter<String>(Main2Activity.this,android.R.layout.simple_spinner_dropdown_item, worldlist));

            // Spinner on item click listener
            mySpinner
                    .setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                        @Override
                        public void onItemSelected(AdapterView<?> arg0,
                                                   View arg1, int position, long arg3) {
                            // TODO Auto-generated method stub
                            // Locate the textviews in activity_main.xml
//                            TextView txtrank = (TextView) findViewById(R.id.rank);
//                            TextView txtcountry = (TextView) findViewById(R.id.country);
//                            TextView txtpopulation = (TextView) findViewById(R.id.population);
//
//                            // Set the text followed by the position
//                            txtrank.setText("Rank : "
//                                    + world.get(position).getRank());
//                            txtcountry.setText("Country : "
//                                    + world.get(position).getCountry());
//                            txtpopulation.setText("Population : "
//                                    + world.get(position).getPopulation());
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> arg0) {
                            // TODO Auto-generated method stub
                        }
                    });
        }
    }
}
