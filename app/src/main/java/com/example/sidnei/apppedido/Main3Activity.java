package com.example.sidnei.apppedido;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.ParseException;

public class Main3Activity extends AppCompatActivity {

    private Button btnProduto;
    private EditText edtFornecedor;
    private EditText edtData;
    private EditText edtPagamento;
    private long idPedido ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        edtFornecedor = (EditText) findViewById(R.id.edtFornecedor);
        edtData = (EditText) findViewById(R.id.edtData);
        edtPagamento = (EditText) findViewById(R.id.edtPagamento);

        btnProduto = (Button) findViewById(R.id.btnProdutos);

    }

    public void IncluirClick(View view) throws ParseException {
        Integer codFornecedor = Integer.parseInt(edtFornecedor.getText().toString());
        Integer codEmpresa = 1; //trocar pela variavel publica da mainactivity
        Integer codUnNegocio = 1; //trocar pelo valor da unidade de negocio selecionada no combo
        String data = edtData.getText().toString();
        String pagamento =  edtPagamento.getText().toString();

        // CHAMA A GRAVAÇÃO DA TABELA PEDIDOCOMPRA -
        PedidoCompraDB novoPedido = new PedidoCompraDB(this);

        idPedido = novoPedido.gravaPedidoCompra(new PedidoCompra(0,codFornecedor,codEmpresa, codUnNegocio, data,0.00,pagamento));


        for(int i = 0; i < 5; i++){
            novoPedido.gravaPedidoCompraItem(new PedidoCompraItem(0, idPedido, 1, "produto teste", 5.00, 25.00, 125.00));
        }
    }


}
