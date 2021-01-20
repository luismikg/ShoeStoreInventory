# ShoesIn
![License](https://img.shields.io/github/license/Lambda3/dotnet-commands.svg)

This App has been developed as part of the Udacity Android Kotlin Developer Nanodegree Course for the Exercise Project "Shoe Store app". In this project I applyed my skills in building layouts and navigation files by building a Shoe Store app. The app is building with four screens:

* Login
* Onboarding
* Instruccions
* Shoe listing
* Shoe detail page
<!--
add screenshot images
-->

---

## App 
Designed for Phones and NOT for Tablets

---

## Rubric followed for the Project

### Code Quality

* Correctly use ViewModel and LiveData lifecycle classes in an Android app -
	* The Detail screen needs to add the new item to the view model. The listing screen should be listening to that model and show the new item.

* Correctly implement Single Activity architecture
	* There should only be one activity: MainActivity. Each screen should be a fragment.

* Write error-free code
	* The project's code is error-free.

### Layouts
      
* Create layouts using the correct ViewGroups and Views in an Android app.
	* The project correctly implements LinearLayout and ConstraintLayout to match the complexity of the layout of a page. Using code comments, the project justifies the use of ConstraintLayout or LinearLayout

* Apply Databinding in Layouts to show the correct data to users in multiple layouts.
	1. All layouts will use the <layout> tag to support Databinding.
	2. Detail screen uses the <data> element.
	3. Databinding is set to the appropriate setting in the app build.gradle file 

* Correctly use the <data> and <variable> elements within the layout.
	* The detail layout contains an <data> element with the name of the variable and the class associated with it.
		* All EditViews correctly refer to created class variable

* Create a multi-screened Android Application using Android widgets.
	* The app contains at least 5 screens.
	* The app contains correctly laid-out labels and edit fields for each screen.
	* The app contains button positioned below the text fields

* List screen uses ScrollView and LinearLayout for showing a list of items and one Floating Action button for going to the detail screen.
Creates a layout for the item.
	1. A new item layout is created for each item
	2. New item layout is added to LinearLayout
	3. Layout is updated with items added on the detail screen
      
* Create a detail screen that shows two columns of labels and edit views to enter in a new item.
	1. Layout created with a label & edit view for each item
	2. Uses data binding to save data
	3. Uses a save button to save data to view model

### Navigation

* Create a navigation file that correctly takes a user from one page to the next in an Android app
	* The app needs to traverse the following screens in the correct order:
      	* Login
      	* Welcome
      	* Instructions screen
      	* Listing screen
      	* Detail screens
            The app should also be able to navigate back via the back arrow or the back button.
      	* A navigation file has been created that defines a start destination.
      	* All destinations have a fragment, label and action associated with it

* Use Databinding for click listeners on a navigation screen in an Android app.
	1. All code will use the DataBindingUtil class to inflate the layout.
	2. All click listeners are connected via the DataBindingUtil class and uses the NavController to navigate to the next screen.   

* Create a Logout menu to return to the Login screen.
	* This menu will appear only on the Shoe Listing screen and will return the user to the login screen
      
---

### Things explored/developed in addition to the above defined Rubric

* The student uses styling on the TextViews and buttons
* Layouts look nicer than the basic layout
* Navigation uses Capitalized names for the labels
* Navigation uses enter/exit animations

---

## Icon and Image credits

* App Icon is from: Hiking boot by Jason Dilworth from the  [Noun Project](https://thenounproject.com/).
* Other images: [dribbble](https://dribbble.com/).

---

## License

```
Copyright 2020 Luis Miguel Cabral Guzmán

Licensed under the Apache License, Version 2.0 (the "License"); 
you may not use this file except in compliance with the License. 
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0
   
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
