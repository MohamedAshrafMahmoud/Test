package com.example.test.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.test.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MoreFragment extends Fragment {

    TextView hiUser;
    LinearLayout LMessage, Lphonecall, Ltimer, Lnews, Levent, Lremender, LWeather, Lgame, Lyoutube, Lmusic, Lgallery;
    RecyclerView trendsRecyclerView;
    Toolbar toolbar;

    Class fragmentClass;
    public static Fragment fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_more, container, false);

        hiUser = view.findViewById(R.id.hiUser);
        LMessage = view.findViewById(R.id.LMessage);
        Lphonecall = view.findViewById(R.id.Lphonecall);
        Ltimer = view.findViewById(R.id.Ltimer);
        Levent = view.findViewById(R.id.Levent);
        Lremender = view.findViewById(R.id.Lremender);
        Levent = view.findViewById(R.id.Levent);
        Lnews = view.findViewById(R.id.Lnews);
        LWeather = view.findViewById(R.id.LWeather);
        Lgame = view.findViewById(R.id.lgame);
        Lyoutube = view.findViewById(R.id.Lvideo);
        Lmusic = view.findViewById(R.id.Lmusic);
        Lgallery = view.findViewById(R.id.Lphotos);


        setUpViews();

        return view;

    }

    ///*****************************************************************************//////
    public void setUpViews() {

        //for message goodmorning
        setHI();

        LMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMessage();
            }
        });

        Lphonecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneCall();
            }
        });

        Ltimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
            }
        });

        Levent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startEvent();
            }
        });

        Lremender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRemender();
            }
        });

        Lnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNews();
            }
        });

        LWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWeather();
            }
        });

        Lyoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYoutube();
            }
        });

        Lgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame();
            }
        });

        Lmusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMusic();
            }
        });

        Lgallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
    }
    //////*************************************************************************/////////////////

    private void playGame() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?client=opera&q=play+a+game&sourceid=opera&ie=UTF-8&oe=UTF-8")));

    }

    ////////////////////////////////////////////////////////////////////////////////////////
    private void playMusic() {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_MUSIC_PLAYER);
        startActivity(intent);
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    private void openYoutube() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com")));

    }

    ////////////////////////////////////////////////////////////////////////////////////////
    private void openGallery() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    private void startRemender() {
        LayoutInflater li = LayoutInflater.from(getContext());
        View view = li.inflate(R.layout.remainder_layout, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                getContext());

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(view);

        final EditText title = view.findViewById(R.id.rTitle);
        final EditText hours = view.findViewById(R.id.rHours);
        final EditText min = view.findViewById(R.id.rMin);
        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                addReminder(title.getText().toString(), Integer.valueOf(hours.getText().toString()), Integer.valueOf(min.getText().toString()));

                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

    ////////////////////////////////////////////////////////////////////////////////////////
    private void startEvent() {
        LayoutInflater li = LayoutInflater.from(getContext());
        View view = li.inflate(R.layout.event_layout, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                getContext());

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(view);

        final EditText begin = view.findViewById(R.id.begin);
        final EditText end = view.findViewById(R.id.end);
        final EditText title = view.findViewById(R.id.title);
        final EditText country = view.findViewById(R.id.country);
        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                addEvent(title.getText().toString(), country.getText().toString(), Integer.valueOf(begin.getText().toString()), Integer.valueOf(end.getText().toString()));

                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

    ////////////////////////////////////////////////////////////////////////////////////////
    private void startTimer() {
        LayoutInflater li = LayoutInflater.from(getContext());
        View view = li.inflate(R.layout.timer_layout, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                getContext());

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(view);

        final EditText length = view.findViewById(R.id.length);

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                setTimer(Integer.valueOf(length.getText().toString()));

                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

    ////////////////////////////////////////////////////////////////////////////////////////
    private void setMessage() {
        LayoutInflater li = LayoutInflater.from(getContext());
        View view = li.inflate(R.layout.msg_layout, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                getContext());

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(view);

        final EditText to = view.findViewById(R.id.to);
        final EditText message = view.findViewById(R.id.msg);
        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                String phone = to.getText().toString();
                                String msg = message.getText().toString();
                                sendsms(phone, msg);
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    private void setHI() {
        Calendar now = Calendar.getInstance();
        if (now.get(Calendar.AM_PM) == Calendar.AM) {
            hiUser.setText("Good Morning");
        } else {
            hiUser.setText("Good Evening");
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    public void sendsms(String phoneNumber, String message) {

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + phoneNumber));
        intent.putExtra("sms_body", message);
        startActivity(intent);
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    public void phoneCall() {
        Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(intent, 1);
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    public void setTimer(int length) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "Set Timer")
                .putExtra(AlarmClock.EXTRA_LENGTH, length)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    public void showNews() {
        Toast.makeText(getContext(), "in implementation ...", Toast.LENGTH_SHORT).show();
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    public void addEvent(String Title, String Country, int beginTime, int endTime) {
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, Title)
                .putExtra(CalendarContract.Events.EVENT_LOCATION, Country)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    public void addReminder(String alarmName, int hours, int miniutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, alarmName)
                .putExtra(AlarmClock.EXTRA_HOUR, hours)
                .putExtra(AlarmClock.EXTRA_MINUTES, miniutes);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    ////////////////////////////////////////////////////////////////////////////////////////
    public void getWeather() {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=London,uk&appid=b59be4612194f3f0d6aa74f5854847de&units=Imperial";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, "", new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject main_object = response.getJSONObject("main");
                    JSONArray array = response.getJSONArray("weather");
                    JSONObject object = array.getJSONObject(0);
                    String temp = String.valueOf(main_object.getDouble("temp"));
                    String description = object.getString("description");
                    String city = response.getString("name");




                    LayoutInflater li = LayoutInflater.from(getContext());
                    View view = li.inflate(R.layout.weather_layout, null);

                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                            getContext());

                    // set prompts.xml to alertdialog builder
                    alertDialogBuilder.setView(view);

                    final TextView T_temp = view.findViewById(R.id.temp);
                    final TextView T_city = view.findViewById(R.id.city);
                    final TextView T_description = view.findViewById(R.id.description);
                    final TextView T_date = view.findViewById(R.id.date);

//                    T_temp.setText(temp);
                    T_city.setText(city);
                    T_description.setText(description);

                    Calendar calendar=Calendar.getInstance();
                    SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd-MM-EEEE");
                    String date=simpleDateFormat.format(calendar.getTime());

                    T_date.setText(date);

                    double temp_int=Double.parseDouble(temp);
                    double centi=(temp_int-32)/1.8000;
                    centi=Math.round(centi);
                    int i =(int)centi;
                    T_temp.setText(String.valueOf(i));

                    alertDialogBuilder
                            .setCancelable(false)
                            .setPositiveButton("OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();




                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(jsonObjectRequest);
    }


    ////////////////////////////////////////////////////////////////////////////////////////
//     public void onBackPressed() {
////        getActivity().onBackPressed();
////        startActivity(new Intent(getContext(), Main2Activity.class));
//         Fragment mFragment = new HomeFragment();
//         getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.explorepage, mFragment).commit();
//
//     }


}
