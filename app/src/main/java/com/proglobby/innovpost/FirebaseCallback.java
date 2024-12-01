package com.proglobby.innovpost;

import java.util.List;

public interface FirebaseCallback {
    void onIndexCallback(int index);

    void onCallback(List<Ticket> tickets);

}
