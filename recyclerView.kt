1. recyclerView.layoutManager=LinearLayaoutManager(this) // step 1


//step 2 creating adapter class 


Class MovieAdapter():RecyclerView.Adapter<MovieViewHolder>()
{
  
  
  //viewholder inflate the xml 
  override fun onCreateViewHolder(parent:ViewGroup,viewType:Int):MovieViewHolder {
  
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
    return MovieViewHolder(view)
    
  }
  
  //this binds the data in holder

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
        val currentItem=items[position]
        holder.titleView.text=currentItem
    }
//tells how many items will be there in list
    override fun getItemCount(): Int {
        return items.size
    }
}
}

//title view is the textView show the title and we are getting it here via this ViewHolder


class MovieViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
  
  val titleView:TextView=itemView.FindViewById(R.id.title)
  
  
}




