package renansander.cronogramanovo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import renansander.cronogramanovo.ListaProfessoresActivity;
import renansander.cronogramanovo.R;
import renansander.cronogramanovo.models.ProfessorModel;

public class ProfessorAdapter extends RecyclerView.Adapter<ProfessorAdapter.ProfessorHolder> {

    ListaProfessoresActivity listaProfessoresActivity;
    List<ProfessorModel> allProfessores;

    public ProfessorAdapter(ListaProfessoresActivity listaProfessoresActivity, List<ProfessorModel> allProfessores) {
        this.listaProfessoresActivity = listaProfessoresActivity;
        this.allProfessores = allProfessores;
    }

    @NonNull
    @Override
    public ProfessorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProfessorHolder(LayoutInflater.from(listaProfessoresActivity).inflate(R.layout.lista, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProfessorHolder holder, int position) {


        holder.itemTxt.setText(allProfessores.get(position).getNomeProfessor());
        holder.descricao.setText(allProfessores.get(position).getDescricaoProfessor());
        Glide.with(listaProfessoresActivity)
                .load(allProfessores.get(position).getImageProfessor())
                .into(holder.imgView);

//        holder.itemTxt.setText(allProfessores.get(position).getNomeProfessor());
    }

    @Override
    public int getItemCount() {
        return allProfessores.size();
    }

    class ProfessorHolder extends RecyclerView.ViewHolder{
        TextView itemTxt;
        TextView descricao;
        ImageView imgView;

        public ProfessorHolder(@NonNull View itemView) {
            super(itemView);
            descricao = itemView.findViewById(R.id.itemDesc);
            itemTxt = itemView.findViewById(R.id.itemTxt);
            imgView = itemView.findViewById(R.id.imgView);
        }
    }

}


