##Lesson 1A_Building Layouts

##Lesson 1B_Building Layouts

*** 
####Evenly Spacing Out Views
So I asked you to try your best at reading this article on linear layout, knowing that your probably would run into concepts and terms that you may not understand but that's totally okay.
Hopefully, each time you read the documentation, you will understand a little more each time.
We're going to spend the next few videos learning about layout weight in more detail.
But here's one thing that could be useful to our problem at hand.
This section is called Equally weighted children, and it talks about how we can create a linear layout where each child is given an equal amount of space, whether it's a vertical layout or a horizontal linear layout.
For a vertical linear layout, we would set the layout height attribute of each child view to be zero dp.
Then we would need to set the layout weight attribute of each view to be one.
I'll show you what this looks like in the next video.

***
####Layout Weight
In the last quiz we were trying to figure out how to give the Tom, Tim and Todd text views a little more personal space by spacing them out equally vertical across the height of the device.
We tried setting a fixed dp value, but that wouldn't work if we switch to a taller device like a tablet.
Then we tried match_parent, but then that made the Tom text view really big.
But then it knocked the other two textees off the screen.
So then we started researching about linear layout weights.
In the documentation, it said that for a vertical linear layout, if we want to equally space out the children, we need to set the height to be zero dp and a weight value of one for each of the children.
Assigning a weight value to a child view is like assigning an importance value to it.
The higher the weight value, the more space it may get if there is available space in the parent left.
For example, for this vertical linear layout, it fills down vertical this way.
It turns out that this linear layout has a lot of extra space, and that will be distributed to the children that have weight values.
If a child has a very high weight value, then more of this available height will be given to that child.
If a child has a very tiny weight value, then less of this available height will be given to that child.
I can show you what it looks like.
I'm going to set the height of this child to be 0dp and then give it a weight of 1.
The linear layout first lays out Tim and Todd TextViews, because they have a fixed height based on the content inside of it.
And then there's this Tom TextView that has an initial height of 0dp, but a weight of 1.
None of the other children have a weight value, because the default weight value is zero if it's not specified.
So this is the only child with a weight value.
So the parent gives all of the remaining height of the screen to this Tom TextView.
And that's why you see the Tome TextView is so giant.
Let me try assigning weight values to the other children now.
So now each child has a height of 0dp and weight of 1.
This is the process that the linear layout would go through.
It would try to figure out the height of each of these views.
The height of these views starts at 0dp.
So that means the available remaining height in the parent is basically the whole height of the screen.
It divides the whole height of the screen by the weight sum, which is three.
And then it gives one-third of that available height to Tom text view, one-third of the height to the Tim text view, and one-third th the Todd text view.
These will still be evenly spaced across the height of a device even on larger screen devices as well because of this weight value.
If I change the weight value to be something higher, then the parent will give more available height to the Tim TextView.
I can change it to an even higher weight value, and you can see how it continues to get more available height.
In this case, the Tim TextView has a weight of 8.
Tom has a weight of 1, and Todd has a weight of 1.
So the weight subtotal is eight, nine, ten.
So the parent divides the available height divided by ten.
And one-tenth goes to Tom, eight-tenths goes to Tim, and one-tenth goes to Todd.
So for a vertical linear layout, say we have 3 child TextViews.
We set the initial height to be 0dp.
So they're all stacked up at the top of the screen with 0 height.
That means the parent has all this extra height available.
If I set a weight of 1 on each child TextView, then the available parent height will be distributed equally across each of the children.
The same would work for horizontal linear layout.
Say we have 3 child text views.
We start with a width of 0dp.
That means the parent has all this extra width available.
If I assign a weight value of 1 to each child view, then we're going to take the available width left in the parent and distribute it equally among each child.
And again, it doesn't have to have a weight of 1.
It could be to three or any other value.
Or it could even have a weight of zero.
If a view has a weight of zero, that means that it won't change depending on the available space left in the parent.
It will basically stay the width and the height that you give it.
One thing I want to point out is when to set the height to be 0 or the width to be 0.
If you have a vertical linear layout, you're filling the linear layout vertically this way.
So you don't know what the height should be, so you set the height to be initially 0dp, and you give it a weight value.
Similarly for horizontal linear layout, you're filling it horizontally.
So you don't know width yet of the child views.
So you set the width to be 0dp, and give it a weight value.
Essentially, you can think of assigning a weight value to a view as being able to stretch it out depending on how big the parent view is.
This is good for filling in the available space within a small device or a large device.

***
####Relative Layout
The reason why this TextView is aligned to the left edge of the parent, even if we didn't set this value, is because all views that are added to the relative layout, are positioned by default in the top left corner of the view group.

All of these attributes are called view group layout parameters.
Even though they're declared on the child XML elements, they're used by the parent view group to know how to position the children.

Experienced developers become quite good at this because then they don't need to actually run it on a device to know what it would look like.
They can just modify the code here and just keep working on it, knowing in their head what it would look like.

***
####Relative to Other Views
The format starts with @ symbol, @ refers to a resource in our Android app.
Then we specify the resource type.
In this case, the resource type is an id.
We also add the plus symbol because this is the *first time* we're declaring this id.
Then we have a slash and then we have the name of the view.

The basic requirements are that the name can't have any spaces.
That's why we use *underscore* symbols here.
It needs to start with a letter and it can't contain any of the weird punctuation symbols.

When you come up with view ID names, make sure that they're all *unique* names.
Usually, picking something *related to the content* inside of it is helpful.

By thw way, we just introduced a ton of new attributes.
But don't feel like you have to memorize all of them.
You can always look them up at any time.

***
####List Item with RelativeLayout
There's no orientation attribute needed for the relative layout.
The photo was already positioned correctly.
The first child of a relative layout is always positioned by *default* in the *top left corner*.

***
####Padding vs Margin
In order to add a margin, you need to put it inside a ViewGroup, so that's why I have it in this linear layout here.

So even though you declare padding or margin on child TextView, the padding gets handled by the TextView *itself*.
Whereas the margin gets handled by the *parent viewGroup*.
If you both of these on a real device, and you didn't have a background for the TextView, then technically both would look the same.
The text would start eight dips over from the left, and eight dips below the top of the device.
However, if you do have a background color for the TextView, then the user would be able to see that the TextView is this big.
Whereas, on the other device, the TExtView would only be this big.

You can think of having a margin as having a little force field around this view.
No other view can enter this eight dip region around it.

The material design guidelines recommend that you use increments of *eight* dips.
This is a little bit more advanced knowledge, but essentially we want our components to line up on the screen along this eight dip square grid.

So by lining everything up, it makes your app easier to read and use.

***
####Chatting with Android Developer Part2
So when things are simple, you don't necessarily want to start writing custom layouts.
Don't just use relative layout everywhere because it's more versatile than linear layout for example.
That's just overkill for simple things.



***
***

##Lesson 2A_Making an App Interactive
***
Three Step to build layout
1.Select views (Whick views?)
2.Position views (Which ViewGroups are relevant?)
3.Style views (Anything we need to do here?)
构建界面布局三步走:
1.选择你需要的view
2.view应该按照什么样子来布局
3.每一个view应该设置什么属性来达到你想要的样子

#####About the attribute textAllCaps
The reason why it's better to use this attribute to capitalize the text is because if we ever want to change the UI so that quantity is in lower case, like this, all we need to do is just remove this attribute instead of going and changing this text.
为什么我们选择添加一个属性来使全字母大写,而不是将字符串直接设定为全大写?
因为当我们如果有了新的需求,比如不想要大写了,可以不必改变字符串值,只要改变或者删去这个属性即可.
这里体现的思想是,通过添加附加属性或组件来为事物改变形态,而不是换一个新的事物.

***
####The Need for Variables
A variable doesn't have a *fixed* value.You can think of a variable like a box like this.
变量就像一个可置换其中内容的箱子,并没有一个固定的值.

DataType VariableName = InitialValue;
声明变量的格式

Equal means assigning a value to a variable.
等号,意味着将一个值赋给变量(即从右到左的实现顺序)

If it's a really obvious error like a java syntax error, then Android's DU can catch that for you and show a red error before it tries to install the app on your phone.
This is called the *compile time error* because it will fail to create any app to even install on your device.
But sometimes the error only happens when you start using the app.
This is called a run time error because it happens when your app is running.
错误分为编译期错误和运行期错误.前者编译期会直接告诉我们哪里有问题,在修正问题前不允许代码的执行.而后者是在运行程序是才会暴露出来的问题,它往往带来很多麻烦,需要我们去测试和寻找问题所在.

A system log is kind of like a diary that your phone keeps about what's happening on the device.
We also call it logcat.
系统日志就像手机记录下来的日记一样,事无巨细地记在了在这台设备上都发生了些什么.


***
####Update Data
Pseudocode is a high level description that explains the steps of what the app will do.
We can write it out as if we're describing it to someone, because it's meant for people to read, not computers.
This helps us put our thoughts into a linear flow of what needs to happen one step after the next.
When writing pseudocode we don't have to follow any specific structure or format, we just need to include useful details that would help us write the code later on.
伪代码,是一种高级语言,用来描述事物执行的步骤.
这是以人类思路书写的语言,不是为计算机而写的,所以不用担心看不懂.
(请注意,伪代码基本都是英文的,都是英文的,都是英文的)
伪代码以一种线性思路的方式帮助人理解事物一步步发展的顺序和执行内容
并没有什么特定的书写格式,只需要将能帮助读者梳理代码思路的细节写入,即可.

For best practice, remember that we always add a space before and after any operators.
约定俗成的书写格式.

***
####Make the Quantity Picker Work
Variable scope means that when a variable is declared in a method, it can be only used in the scope of that method.
变量根据其可被使用的范围,可以分为全局变量和局部变量.
这里关系到变量的生命周期.

***
####Fix the Order Button
Describe in words the gap between what we have now and what we want. 
The more specific you can get about all the things that are wrong with the app, the easier it will be to fix the problem because you'll have almost a task list on how to get to the ideal solution.
往往在设计一个程序时,详细描述出现在已经有的成果和预想中成果之间的差距.
你描述的越详细,你就越能挖掘到那些不同和错误的细节,也就越容易修正问题.
因为对这种差距的描述已经为你列出如何将想法实现的任务清单

***
####Fix the Order Button - Solution
Technically you can have a local variable called the same name as a global variable.
This just means that in the context of this method, after this variable has been declared, whenever you refer to quantity, it actually refers to this local quantity variable with value 5, not the global quantity variable of value 2.
技术上来说,拥有同名的全局变量和局部变量是被允许的.
但是这意味着在局部变量可以生效的范围内(往往是一个方法内),调用这个变量,使用的将是局部变量的值,而不是全局变量.

***
***
##Lesson 2B_Making an App Interactive
***
####Plan Quantity Picker Layout
Being able to teach others about what you've built feels rewarding, but it's also a core skill in being able to communicate with teammates that you may work with on a software project.

***
####Nested ViewGroups
Nested viewgroups means putting viewgroups inside other viewgroups.

You can nest as many view groups inside other view groups as you want.
However, be careful because the more nesting that you do, the more expensive it will be for your app to lay out on the screen.

The way that Android organizes all these views on screen is in a view hierarchy, or a tree structure of views.
This is simple a diagram that represents the view hierarchy.
It shows the parent and child relationships among the views.

***
####Create the String Variable
escape characters---escape sequences
An escape sequence is a character preceded by a backslash, and the Java compiler will interpret it in a special way.

***
####Combining Strings Together
When dealing the strings in Java, an important concept to understand is string concatenation.It just means we're joining character strings together end to end.
You can combine two string by concatenating them to make an even longer string.
To concatenate these strings together, we use the *plus operator*.

You can also concatenate strings with integers like I have here.
Before, the ten was in quotes so that was a string representation of the number ten.
But here I just have 100 without quotes, so this is the integer value for 100.
If I concatenate a string with an integer, then it immediately turns this whole thing into a *string*.

***
####Chatting with Android Developer Part2
And I think a good engineer you don't have to know everything.
But you really, you have to be good at like *figuring out* like, *you know where the answer is*.
You can probably look for, there's a lot of good tutorials out there for, just have to know how to look for the right key words.
Search for the right key words.

I think the really good engineers, they're not only focus on what they're doing, but they... you know we have these things called tech talks at work.
They often know what the latest technologies are, from these tech talks or announcements that are sent to the entire engineering org.
So, just being on top of.

>Q:And let's go back to the time when you were actually learning to program.
>If you could talk to the Alice at that time, what advice would you give her today?

A:I feel like I should have had more fun with programming.So I think the way I learned to program, and I think it's very different now, because I grew up in, originally I'm from China.So I think it was very academically focused.
And I think looking back, I wish I had like done more fun-type projects.

***
***



##Lesson 3A_Object Oriented Programming

##Lesson 3B_Object Oriented Programming

##Practice Set 1

##Practice Set 2

##Coffee Break Challenge
