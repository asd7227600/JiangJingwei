//package cn.studyjams.s1.sj43.jiangjingwei.activity;
//
//import android.app.FragmentTransaction;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentActivity;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentStatePagerAdapter;
//import android.support.v4.view.ViewPager;
//import android.os.Bundle;
//import android.app.ActionBar;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import cn.studyjams.s1.sj43.jiangjingwei.R;
//
//public class CollectionActivity extends FragmentActivity {
//    // When requested, this adapter returns a DemoObjectFragment,
//    // representing an object in the collection.
//    DemoCollectionPagerAdapter mDemoCollectionPagerAdapter;
//    ViewPager mViewPager;
//
//    public void onCreate(Bundle savedInstanceState) {
//        final ActionBar actionBar = getActionBar();
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_collection);
//
//        // ViewPager and its adapters use support library
//        // fragments, so use getSupportFragmentManager.
//        mDemoCollectionPagerAdapter =
//                new DemoCollectionPagerAdapter(
//                        getSupportFragmentManager());
//        mViewPager = (ViewPager) findViewById(R.id.pager);
//        mViewPager.setAdapter(mDemoCollectionPagerAdapter);
//        mViewPager.setOnPageChangeListener(
//                new ViewPager.SimpleOnPageChangeListener() {
//                    @Override
//                    public void onPageSelected(int position) {
//                        getActionBar().setSelectedNavigationItem(position);
//                    }
//                }
//        );
//
//        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//
//        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
//            @Override
//            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
//                mViewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
//
//            }
//
//            @Override
//            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
//
//            }
//        };
//
//        for (int i = 0; i < 3; i++) {
//            actionBar.addTab(
//                    actionBar.newTab().setText("Tab" + (i + 1))
//                            .setTabListener(tabListener)
//            );
//        }
//
//
//
//    }
//
//
//    // Since this is an object collection, use a FragmentStatePagerAdapter,
//    // and NOT a FragmentPagerAdapter.
//    public class DemoCollectionPagerAdapter extends FragmentStatePagerAdapter {
//        public DemoCollectionPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int i) {
//            Fragment fragment = new DemoObjectFragment();
//            Bundle args = new Bundle();
//            // Our object is just an integer :-P
//            args.putInt(DemoObjectFragment.ARG_OBJECT, i + 1);
//            fragment.setArguments(args);
//            return fragment;
//        }
//
//        @Override
//        public int getCount() {
//            return 100;
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return "OBJECT " + (position + 1);
//        }
//    }
//
//    // Instances of this class are fragments representing a single
//    // object in our collection.
//    public static class DemoObjectFragment extends Fragment {
//        public static final String ARG_OBJECT = "object";
//
//        @Override
//        public View onCreateView(LayoutInflater inflater,
//                                 ViewGroup container, Bundle savedInstanceState) {
//            // The last two arguments ensure LayoutParams are inflated
//            // properly.
//            View rootView = inflater.inflate(
//                    R.layout.fragment_collection_object, container, false);
//            Bundle args = getArguments();
//            ((TextView) rootView.findViewById(android.R.id.text1)).setText(
//                    Integer.toString(args.getInt(ARG_OBJECT)));
//            return rootView;
//        }
//    }
//}
//
//
