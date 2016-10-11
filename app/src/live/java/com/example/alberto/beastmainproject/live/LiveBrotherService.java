package com.example.alberto.beastmainproject.live;

import android.util.Log;

import com.example.alberto.beastmainproject.entities.Brother;
import com.example.alberto.beastmainproject.entities.firebase.BrotherFirebase;
import com.example.alberto.beastmainproject.infrastructure.BeastApplication;
import com.example.alberto.beastmainproject.services.BrotherServices;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class LiveBrotherService extends BeastLiveService {

    public LiveBrotherService(BeastApplication application) {
        super(application);
    }

    @Subscribe
    public void postBrothers(BrotherServices.SearchBrotherRequest request) {
        final BrotherServices.SearchBrotherResponse response = new BrotherServices.SearchBrotherResponse();
        response.brothers = new ArrayList<>();

        Firebase reference = new Firebase(request.fireBaseUrl);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int index = 0;
                for (DataSnapshot childSnapshot: dataSnapshot.getChildren()) {
                    BrotherFirebase brotherFirebase = childSnapshot.getValue(BrotherFirebase.class);

                    Brother brother = new Brother(
                            index,
                            brotherFirebase.getName(),
                            brotherFirebase.getWhy(),
                            brotherFirebase.getPicture(),
                            brotherFirebase.getMajor(),
                            brotherFirebase.getCross(),
                            brotherFirebase.getFact()
                    );

                    response.brothers.add(brother);
                    index++;
                }

                bus.post(response);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.e(LiveBrotherService.class.getSimpleName(), firebaseError.getMessage());
            }
        });

//        for (int i = 0; i < 32; ++i) {
//            response.brothers.add(new Brother(
//                    i,
//                    "Brother " + i,
//                    "Brother " + i + " joined for that",
//                    "http://www.gravatar.com/avatar/" + i + "?d=identicon",
//                    "Mechanical Engineering",
//                    "Spring 2013",
//                    "Whatever"
//            ));
//
//        }
//
//        int index = 0;
//        // Create a storage reference from our app
//        Firebase reference = new Firebase(BeastLiveService.FIREBASE_REFERENCE);
//
//        for (Brother brother: response.brothers) {
//            Firebase brotherReference = reference.child("data").child("brothers").child(Integer.toString(index));
//            brotherReference.child("name").setValue(brother.getBrotherName());
//            brotherReference.child("fact").setValue(brother.getBrotherFunFact());
//            brotherReference.child("picture").setValue(brother.getBrotherPicture());
//            brotherReference.child("major").setValue(brother.getBrotherMajor());
//            brotherReference.child("cross").setValue(brother.getBrotherCrossSemester());
//            brotherReference.child("why").setValue(brother.getBrotherWhyJoin());
//            index++;
//        }
//
//        bus.post(response);
    }
}
