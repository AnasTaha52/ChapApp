
package com.example.chatapp.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatapp.databinding.ItemContainerRecentChatsBinding;
import com.example.chatapp.listeners.ConversionListner;
import com.example.chatapp.models.ChatMessage;
import com.example.chatapp.models.User;

import java.util.List;

public class RecentConversationsAdapter extends  RecyclerView.Adapter<RecentConversationsAdapter.ConversionViewHolder>{

    @NonNull
    @Override
    public ConversionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ConversionViewHolder(
                ItemContainerRecentChatsBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ConversionViewHolder holder, int position) {
        holder.setData(chatMessages.get(position));
    }

    @Override
    public int getItemCount() {
        return chatMessages.size();
    }
    private final List<ChatMessage> chatMessages;
    private final ConversionListner conversionListner;
    public RecentConversationsAdapter(List<ChatMessage> chatMessages , ConversionListner conversionListner){
        this.chatMessages = chatMessages;
        this.conversionListner = conversionListner;
    }
    class ConversionViewHolder extends RecyclerView.ViewHolder {
        ItemContainerRecentChatsBinding binding;

        ConversionViewHolder(ItemContainerRecentChatsBinding itemContainerRecentChatsBinding){
            super(itemContainerRecentChatsBinding.getRoot());
            binding= itemContainerRecentChatsBinding;

        }
        void setData(ChatMessage chatMessage){
            binding.imageProfile.setImageBitmap(getConversionImage(chatMessage.conversionImage));
            binding.textName.setText(chatMessage.conversionName);
            binding.textRecentMessage.setText(chatMessage.message);
            binding.getRoot().setOnClickListener(v -> {
                User user = new User();
                user.id = chatMessage.conversionId;
                user.name = chatMessage.conversionName;
                user.image = chatMessage.conversionImage;
                conversionListner.onConversionClicked(user);

            });
        }
    }

    private Bitmap getConversionImage(String encodedImage){
        byte[] bytes = Base64.decode(encodedImage ,Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes , 0 , bytes.length);

    }
}

