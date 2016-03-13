# Android Data Dinding Sample
Android Data Binding Sample.

## Android实现DataBinding步骤：

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

第二种方式：

```java
User user = new User("jingle1267", "20");
  
// 第二种初始化方式
ViewDataBinding binding1 = DataBindingUtil.setContentView(this,
    R.layout.activity_data_binding_sample1);
binding1.setVariable(BR.user, user);
```

  实现上述步骤之后，编译运行，就可以看到用户名和年龄显示到对应的控件。