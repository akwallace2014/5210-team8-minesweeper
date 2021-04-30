# MineSweeper
This is a classic minesweeper we all know from old versions of Windows, with refreshed graphics.<br> 
Created using JavaFx but on the branch <code>swing</code> there is a discontinued version created 
in Swing. (looks more old-fashioned)<br> 
I'm also planning to introduce classic MineSweeper like theme. (Winows 95-XP)

<p> Bomb icon is created by 
<a href="https://www.flaticon.com/authors/pixel-perfect ">Pixel perfect</a>
 from <a href="http://www.flaticon.com/">www.flaticon.com</a></p>


## ![enter image description here](https://res.cloudinary.com/canonical/image/fetch/f_auto,q_auto,fl_sanitize,w_60,h_60/https://dashboard.snapcraft.io/site_media/appmedia/2017/11/icon_CE_256_2Qe5uEl.png) IntelliJ IDE Set-Up and Building 
Follow these steps to get this repository set-up in IntelliJ to build and run. 

1. Clone repository locally (File --> New --> Project from Version Control.. )
	Paste in the repo URL and click *Clone*.
			<a href="https://www.youtube.com/watch?v=aBVOAnygcZw&t=76s&ab_channel=IntelliJIDEAbyJetBrains">IntelliJ Instructions </a>

2. Verify that your current Gradle JVM is set to one of a JDK of v1.8. (Amazon Corretto shown here) To do so navigate to Settings --> Build, Execution, Deployment --> Build Tools --> Gradle --> Gradle JVM ![Verify Gradle JVM](https://i.imgur.com/ASq5Fhu.png)

3.  Verify that your Project is set to use a JDK that supports JavaFX to do this navigate to File --> Project Structure --> Project Settings --> Project --> Project SDK  |  The JavaFX SDK and Runtime are included in the JDK, starting with Java SE 7 Update 2. Download the JDK bundle from the [JavaFX Downloads page](http://www.oracle.com/technetwork/java/javafx/downloads/index.html), then go to the [JDK Installation Guide](http://docs.oracle.com/javase/7/docs/webnotes/install/windows/jdk-installation-windows.html). Or use a OpenJDK that supports JavaFX (Corretto 1.8 works fine)

4. Make sure you have JUnit 5 as part of the projects libraries. The easier way to do this (if NOT already incorporated into your project libraries) is to follow the intelliJ recommended import as seen in the right-click menu below from any of the testing class' import statetments.
![enter image description here](https://i.imgur.com/GjdKocp.png)

5. Run Test Suite or Build and Play! 
