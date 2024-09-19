package vn.edu.usth.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class ChatAdapter  extends RecyclerView.Adapter<ChatAdapter.ChatHolder>{
    private List<Chat> chatList;


    public void setData(List<Chat> chatList ){
        this.chatList = chatList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ChatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat,parent,false);
        return new ChatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatHolder holder, int position) {
            Chat chat = chatList.get(position);
            if(chatList == null){
                return;
            }

            holder.chat_view.setText(chat.getMessage());
    }

    @Override
    public int getItemCount() {
        if(chatList != null){
            return chatList.size();
        }


        return 0;
    }

    public class ChatHolder  extends RecyclerView.ViewHolder{
    private TextView chat_view;

        public  ChatHolder(View itemview) {
            super(itemview);
            chat_view = itemview.findViewById(R.id.chat_view);

        }


    }
}
