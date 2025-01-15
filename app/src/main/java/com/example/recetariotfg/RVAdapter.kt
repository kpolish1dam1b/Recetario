package com.example.recetariotfg

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(private val recipeList: ArrayList<Recipe>) : RecyclerView.Adapter<RVAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RVAdapter.MyViewHolder, position: Int) {
        val recipe : Recipe = recipeList[position]

        holder.name.text = recipe.name;
        holder.type.text = recipe.type;
        holder.ingredients.text = recipe.ingred;
        holder.instructions.text = recipe.instructions;
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    public class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val name : TextView = itemView.findViewById(R.id.tvName)
        val type : TextView = itemView.findViewById(R.id.tvType)
        val ingredients : TextView = itemView.findViewById(R.id.tvIngredients)
        val instructions : TextView = itemView.findViewById(R.id.tvInstructions)
    }
}