# Android Data Dinding Sample

  Data Binding 解决了 Android UI 编程中的一个痛点，官方原生支持 MVVM 模型可以让我们在不改变既有代码框架的前提下，非常容易地使用这些新特性。Google 2015 IO大会中对于Android开发曾了Data Binding。

## Android实现数据DataBinding步骤

### 一. 配置全局

  创建一个空的Project，并修改Project的build.gradle，为build script添加一条依赖，Gradle版本最低为1.5.0。
  
```xml
classpath 'com.android.tools.build:gradle:1.5.0'
```

  为用到Data Binding的模块添加插件，修改对应的build.gradle。

```xml
dataBinding {
    enabled = true
}
```

### 二. 创建需要Binding的实体

创建用户的实体<code>User</code> :

```java
public class User {

    public final String name;
    public final String age;

    public User(String name, String age) {
        this.age = age;
        this.name = name;
    }
}
```

### 三. 创建布局文件

Activity的布局文件如下:

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout
    xmlns:android="http://schemas.android.com/apk/res/android">
    <data>
        <variable
            name="user"
            type="com.ihongqiqu.databinding.data.User" />
    </data>

    <LinearLayout
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:gravity="center_horizontal"
        android:orientation="vertical"
        android:paddingBottom="@dimen/activity_vertical_margin"
        android:paddingLeft="@dimen/activity_horizontal_margin"
        android:paddingRight="@dimen/activity_horizontal_margin"
        android:paddingTop="@dimen/activity_vertical_margin"
        tools:context="com.ihongqiqu.databinding.DataBindingSampleActivity1">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentTop="true"
            android:layout_centerHorizontal="true"
            android:layout_marginTop="20dp"
            android:text="@{user.name}"
            android:textAppearance="?android:attr/textAppearanceMedium" />

        <TextView
            android:id="@+id/textView2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerHorizontal="true"
            android:layout_marginTop="27dp"
            android:text="@{user.age}"
            android:textAppearance="?android:attr/textAppearanceMedium" />

    </LinearLayout>
</layout>
```

### 四. 实现数据绑定

Actvity的onCreate()方法实现数据绑定。

第一种方式：

```java
User user = new User("jingle1267", "20");

// 第一种初始化方式
ActivityDataBindingSample1Binding binding = DataBindingUtil.setContentView(this,
    R.layout.activity_data_binding_sample1);
binding.setUser(user);
```

⚠️ 注意: 上面代码是<code>ActivityDataBindingSample1Binding</code>, 而不是我们的Activity： <code>DataBindingSample1BindingActivity</code>

第二种方式：

```java
User user = new User("jingle1267", "20");
  
// 第二种初始化方式
ViewDataBinding binding1 = DataBindingUtil.setContentView(this,
    R.layout.activity_data_binding_sample1);
binding1.setVariable(BR.user, user);
```

  实现上述步骤之后，编译运行，就可以看到用户名和年龄显示到对应的控件。
  
## Android实现事件DataBinding步骤


### 一.实现事件处理类

编写事件处理类，代码如下：

```java
public class MyHandlers {

    public final void onClickName(View view) {
        Toast.makeText(view.getContext(), "onClickName()", Toast.LENGTH_SHORT).show();
    }

    public final void onClickAge(View view) {
        Toast.makeText(view.getContext(), "onClickAge()", Toast.LENGTH_SHORT).show();
    }

}
```

### 二.控件选择处理方法

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout
    xmlns:android="http://schemas.android.com/apk/res/android">
    <data>
        <variable name="myHandlers" type="com.ihongqiqu.databinding.event.MyHandlers"/>
        <variable name="user" type="com.ihongqiqu.databinding.data.User" />
    </data>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:gravity="center_horizontal"
        android:orientation="vertical"
        android:paddingBottom="@dimen/activity_vertical_margin"
        android:paddingLeft="@dimen/activity_horizontal_margin"
        android:paddingRight="@dimen/activity_horizontal_margin"
        android:paddingTop="@dimen/activity_vertical_margin" >

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="20dp"
            android:text="@{user.name}"
            android:onClick="@{myHandlers.onClickName}"
            android:clickable="true"
            android:textAppearance="?android:attr/textAppearanceMedium" />

        <TextView
            android:id="@+id/textView2"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="27dp"
            android:text="@{user.age}"
            android:onClick="@{myHandlers.onClickAge}"
            android:clickable="true"
            android:textAppearance="?android:attr/textAppearanceMedium" />

    </LinearLayout>
</layout>
```

### 三.实现控件和事件的绑定

Activityd的onCreate()方法添加绑定代码：

**这一步很重要，不实现这一步会导致事件无法出发。**

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setTitle("事件绑定");
    
    User user = new User("jingle1267", "20");
    MyHandlers myHandlers = new MyHandlers();

    ActivityDataBindingSample2Binding binding = DataBindingUtil.setContentView(this,
        R.layout.activity_data_binding_sample2);
    binding.setUser(user);
    binding.setMyHandlers(myHandlers);
}
```

👌OK，通过上述三个步骤就实现了事件的绑定！

## Android使用DataBinding更新数据

  实现数据实时更新，需要在在之前的基础上，额外实现一部分操作。
  
  POJO需要做一下修改，修改后如下，重点是<code>@Bindable</code>和<code>notifyPropertyChanged(BR.XXX);</code>，其中<code>BR.XXX</code>为对应需要更新的ID。具体代码如下：
  
```java
/**
 * 猪，有标签和重量两个属性
 * <p/>
 * Created by zhenguo on 3/13/16.
 */
public class Pig extends BaseObservable {

    private String label;
    private String weight;

    @Bindable
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
        notifyPropertyChanged(BR.label);
    }

    @Bindable
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
        notifyPropertyChanged(BR.weight);
    }
}
```

  事件处理类需要调整如下(仅供参考)，代码中直接修改了实体的属性就实现了对UI的更新：
  
```java
/**
 * 事件处理
 * <p/>
 * Created by zhenguo on 3/13/16.
 */
public class PigHandler {

    DataBindingSampleActivity3 sampleActivity3;

    public PigHandler(DataBindingSampleActivity3 sampleActivity3) {
        this.sampleActivity3 = sampleActivity3;
    }

    public void onClick(View view) {
        if (sampleActivity3 != null && sampleActivity3.pig != null) {
            sampleActivity3.pig.setLabel("长白山");
            sampleActivity3.pig.setWeight("280Kg");
        }
    }

}
```