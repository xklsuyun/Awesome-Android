日期格式化：
	android.text.format.DateFormat类
RecyclerView：
	1).支持动画效果；
	2).移动某一项：RecyclerView.getAdapter().notifItemMoved(0, 5);//将第某一项从0移动到5
	3).返回更新，在onResume()方法中完成；
	4).只更新指定的项：使用notifyItemChanged()的方法；
Fragment:
	1).通过Fragment获取返回结果，不调用Activity的startActivityForResult()和onActivityResult()而使用Activity的两个方法；
ViewPager与PagerAdapter:
	2).可以使用FragmentStatePagerAdapter可为ViewPager内部的添加基于Fragment的项，参考下面这段代码：
	private ViewPager mViewPager;
	private List<Crime> mCrimes;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crime_pager);
		
		mViewPager = (ViewPager)findViewById(R.id.activity_crime_pager_view_pager);
		
		mCrimes = CirmeLab.get(this).getCrimes();
		FragmentManager fragmentManager = getSupportFragmentManager();
		mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager){
			
			@Override public Fragment getItem(int position){
				Crime crime = mCrimes.get(position);
				return CrimeFragment.newInstance(cirme.getId());
			}
			
			@Override int getCount(){
				return mCrimes.size();
			}
		}
	}
	要实现FragmentStatePagerAdapter需要覆写getItem()和getCount()两个方法，在创建的时候需要传入一个FragmentManager对象
	3).FragmentStatePagerAdapter与FragmentPagerAdapter的不同：
	卸载不需要使用的fragment时，处理的方法不同。
	FragmentPagerAdapter调用detach(Fragment)处理，只会销毁视图，Fragment本身会一直保存；
	FragmentStatePagerAdapter调用remove(Framgent)处理，会销毁视图和Fragment，并将状态保存在Bundle中，需要的时候则从Bundle中获取并使用状态恢复Fragment。
	所以，FragmentStatePagerAdpater会比FragmentPagerAdapter更节省内存，尤其是当Fragment中需要的内容比较多时，应该使用FragmentStatePagerAdapter
对话框：
	1.创建基于Fragment的对话框的好处：当设备旋转的时候对话框也不会消失
	2.实现方式：
	1).继承android.support.v4.app.DialogFragment类并实现onCreateDialog方法，在该方法中创建android.support.v7.app.AlertDialog的实例
	，并将其返回；
	2).显示对话框，可以使用所创建的对话框的两个方法
	show(FragmentManager manager,String tag)
	show(FragmentTransaction transaction,String tag)
	3).碎片之间的数据传递(对话框碎片和创建对话框的碎片之间的数据传递)：
	令创建对话框的碎片为A，对话框碎片为B，则
	从A向B传递数据的方式是在创建对话框的时候向它的setArguments()方法传入Bundle
	从B向A返回数据的方式是在创建B的时候设置它的setTargetFragment()传入碎片A和一个RequestCode：
	dialog.setTargetFragment(xxxFragment.this,REQUEST_DATE)
	然后从B返回的时候调用getTargetFragment()方法，并调用onActivityResult()方法，并传入一个Intent(返回的信息在Intent中)
	getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);
关于碎片的：
	1).setHasOptionsMenu(true)
	2).invalidateOptionsMenu()
	3).setRetainInstance(true)调用该方法可以保证当设备旋转的时候fragment不会随Activity一起销毁，它会一直保存并在需要的时候原封不动得传递给新的Activity
字符串显示：
	1).复数字符串显示：
	<plurals name="subtitle_plural">
		<item quatity="one">%1$s crime</item>
		<item quatity="other">%1$s crimes</item>
	</plurals>
关于数据库：
	1).使用下面的方式定义数据库的字段：
	public class CrimeDbSchema{
		public static final class CrimeTable{
			public static final String NAME = "crimes";
			
			public static final class Cols{
				public static final String UUID = "uuid";
				public static final String TITLE = "title";
				// ...
			}
		}
	}																			
	作者在创建数据库时也使用了实体id(UUID)和表id，创建数据库的时候的SQL语句是：
	"create table "+CrimeTable.NAME+" ("+
	"_id integer primary key autoincrement,"+
	CrimeTable.Cols.UUID + ", "+
	CirmeTable.Cols.TITLE + ", "... //显然不需要指定字段类型，这里添加了两个ID
使用Intent：
	检查可以执行指定intent的应用：
	PackageManager manager = getActivity().getPackageManager();
	if(manager.resolveActivity(intent,PackageManager.MATCH_DEFAULT_ONLY) == null){
		mButton.setEnable(false);
	}