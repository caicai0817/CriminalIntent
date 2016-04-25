package com.caicai.criminalintent.designobserver.projectobserver;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.caicai.criminalintent.R;
import com.caicai.criminalintent.designobserver.projectobserver.fragment.HomeFragment;
import com.caicai.criminalintent.designobserver.projectobserver.fragment.MessageFragment;
import com.caicai.criminalintent.designobserver.projectobserver.fragment.MineFragment;
import com.caicai.criminalintent.designobserver.projectobserver.fragment.SquareFragment;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class ProjectObserverActivity extends AppCompatActivity {

    public FragmentManager fragmentManager;
    private MineFragment mineFragment;
    private MessageFragment messageFragment;
    private SquareFragment squareFragment;
    private HomeFragment homeFragment;

    private FrameLayout contentPanel;
    private RadioGroup rgTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_observer);

        contentPanel = (FrameLayout) this.findViewById(R.id.contentPanel);

        Log.e("caicai", getLocalIpAddress());

        rgTab = (RadioGroup) this.findViewById(R.id.rgTab);

        fragmentManager = getSupportFragmentManager();
        mineFragment = MineFragment.newInstance(null, null);
        messageFragment = MessageFragment.newInstance(null, null);
        squareFragment = SquareFragment.newInstance(null, null);
        homeFragment = HomeFragment.newInstance(null, null);

        fragmentManager.beginTransaction().add(R.id.contentPanel, homeFragment).commit();
        fragmentManager.beginTransaction().add(R.id.contentPanel, messageFragment).commit();
        fragmentManager.beginTransaction().add(R.id.contentPanel, squareFragment).commit();
        fragmentManager.beginTransaction().add(R.id.contentPanel, mineFragment).commit();
        fragmentManager.beginTransaction().hide(messageFragment).commit();
        fragmentManager.beginTransaction().hide(mineFragment).commit();
        fragmentManager.beginTransaction().hide(squareFragment).commit();

        rgTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.main_tab_opportunity: {
                        if (homeFragment != null) {
                            fragmentManager.beginTransaction().hide(messageFragment).commit();
                            fragmentManager.beginTransaction().hide(mineFragment).commit();
                            fragmentManager.beginTransaction().hide(squareFragment).commit();
                            fragmentManager.beginTransaction().show(homeFragment).commit();
                        }
                        break;
                    }
                    case R.id.main_tab_process: {
                        if (messageFragment != null) {
                            fragmentManager.beginTransaction().hide(homeFragment).commit();
                            fragmentManager.beginTransaction().hide(mineFragment).commit();
                            fragmentManager.beginTransaction().hide(squareFragment).commit();
                            fragmentManager.beginTransaction().show(messageFragment).commit();
                        }
                        break;
                    }
                    case R.id.main_tab_freetel: {
                        if (squareFragment != null) {
                            fragmentManager.beginTransaction().hide(messageFragment).commit();
                            fragmentManager.beginTransaction().hide(mineFragment).commit();
                            fragmentManager.beginTransaction().hide(homeFragment).commit();
                            fragmentManager.beginTransaction().show(squareFragment).commit();
                        }
                        break;
                    }
                    case R.id.main_tab_mine:
                        if (mineFragment != null) {
                            fragmentManager.beginTransaction().hide(messageFragment).commit();
                            fragmentManager.beginTransaction().hide(homeFragment).commit();
                            fragmentManager.beginTransaction().hide(squareFragment).commit();
                            fragmentManager.beginTransaction().show(mineFragment).commit();
                        }
                        break;
                    default: {
                        break;
                    }
                }
            }
        });

    }

    /**
     * 获取Android本机IP地址
     *
     * @return
     */
    private String getLocalIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface
                    .getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf
                        .getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException ex) {
//            Log.e("WifiPreference IpAddress", ex.toString());
        }
        return null;
    }

}
