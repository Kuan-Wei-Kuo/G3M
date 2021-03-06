package com.example.navigationdrawer;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
 
public class FragmentTest extends Fragment{

	public static String[] titles = new String[]
			{ 
				"英文","數學","物理"
			};
	public static int a;
	
	public static Fragment newInstance(Context context) {
		FragmentTest f = new FragmentTest();
		
        return f;
    }
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_two, null);
        ViewPager viewPager1 = (ViewPager) root.findViewById(R.id.viewpager1);
        viewPager1.setAdapter(new MyFragmentPagerAdapter(getFragmentManager()));
        return root;
    }
	private class MyFragmentPagerAdapter extends FragmentStatePagerAdapter
	{
		public MyFragmentPagerAdapter(FragmentManager fm)
		{
			super(fm);
		}

		@Override
		public Fragment getItem(int position)
		{
			Bundle args = new Bundle();
			args.putInt("position", position);
			if(position==0)
				return Fragment.instantiate(getActivity(), english_test.class.getName(), args);
			else
				return Fragment.instantiate(getActivity(), formula_test.class.getName(), args);
		}

		@Override
		public int getCount()
		{
			return titles.length;
		}
		
		@Override
		public CharSequence getPageTitle(int position)
		{
			a= position;
			return titles[position];
		}
	}
}
