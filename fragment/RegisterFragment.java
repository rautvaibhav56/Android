package com.sunbeam.myproject2.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.sunbeam.myproject2.R;
import com.sunbeam.myproject2.utils.Constants;
import com.sunbeam.myproject2.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class RegisterFragment extends Fragment {


    @BindView(R.id.buttonBack)
    ImageButton buttonBack;
    @BindView(R.id.editfirst_name)
    EditText editfirstName;
    @BindView(R.id.editlast_name)
    EditText editlastName;
    @BindView(R.id.editcontact)
    EditText editcontact;
    @BindView(R.id.editemail)
    EditText editemail;
    @BindView(R.id.editpassword)
    EditText editpassword;
    @BindView(R.id.editaddress)
    EditText editaddress;
    @BindView(R.id.editpin)
    EditText editpin;
    @BindView(R.id.editgender)
    EditText editgender;
    @BindView(R.id.editstate)
    EditText editstate;
    @BindView(R.id.editcountry)
    EditText editCountry;
    @BindView(R.id.buttonRegister)
    Button buttonRegister;
    Unbinder unbinder;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.buttonBack)
    public void onButtonBackClicked() {
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, new LoginFragment())
                .commit();
    }

    @OnClick(R.id.buttonRegister)
    public void onButtonRegisterClicked() {
        final String firstname = editfirstName.getText().toString();
        final String lastname = editlastName.getText().toString();
        final String email = editemail.getText().toString();
        final String password = editpassword.getText().toString();
        final String contact = editcontact.getText().toString();
        final String address = editaddress.getText().toString();
        final String pin = editpin.getText().toString();
        final String state = editstate.getText().toString();
        final String gender = editgender.getText().toString();
        final String country = editCountry.getText().toString();


        if (firstname.length() == 0) {
            Toast.makeText(getActivity(), "Enter first name", Toast.LENGTH_SHORT).show();
        } else if (lastname.length() == 0) {
            Toast.makeText(getActivity(), "Enter last name", Toast.LENGTH_SHORT).show();
        } else if (contact.length() == 0) {
            Toast.makeText(getActivity(), "Enter contact", Toast.LENGTH_SHORT).show();
        } else if (email.length() == 0) {
            Toast.makeText(getActivity(), "Enter email", Toast.LENGTH_SHORT).show();
        } else if (password.length() == 0) {
            Toast.makeText(getActivity(), "Enter password", Toast.LENGTH_SHORT).show();
        } else if (address.length() == 0) {
            Toast.makeText(getActivity(), "Enter address", Toast.LENGTH_SHORT).show();
        } else if (pin.length() == 0) {
            Toast.makeText(getActivity(), "Enter pin", Toast.LENGTH_SHORT).show();
        } else if (gender.length() == 0) {
            Toast.makeText(getActivity(), "Enter gender", Toast.LENGTH_SHORT).show();
        } else if (state.length() == 0) {
            Toast.makeText(getActivity(), "Enter state", Toast.LENGTH_SHORT).show();
        } else if (country.length() == 0) {
            Toast.makeText(getActivity(), "Enter country", Toast.LENGTH_SHORT).show();
        } else {

            JsonObject body = new JsonObject();
            body.addProperty("first_name", firstname);
            body.addProperty("last_name", lastname);
            body.addProperty("email", contact);
            body.addProperty("password", email);
            body.addProperty("contact", password);
            body.addProperty("address", address);
            body.addProperty("pin", pin);
            body.addProperty("gender", gender);
            body.addProperty("state",state);
            body.addProperty("country",country);


            final String url = "http://192.168.43.111:3000/customer";
            Log.d("chekingurl",""+url);
            Ion.with(getActivity())
                    .load(url)
                    .setJsonObjectBody(body)
                    .asJsonObject()
                    .setCallback(new FutureCallback<JsonObject>() {
                        @Override
                        public void onCompleted(Exception e, JsonObject result) {
                            if (e != null) {
                                e.printStackTrace();
                            } else {
                                if (result.get("status").getAsString().equals("success")) {
                                    Toast.makeText(getActivity(), "Successfully registered user", Toast.LENGTH_SHORT).show();
                                    onButtonBackClicked();
                                } else {
                                    Toast.makeText(getActivity(), "Error while registering a user", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });
        }
    }
}