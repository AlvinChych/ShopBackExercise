# ShopBackExercise

- what was your assumptions and design considerations when doing the exercise
	To construct the application for browsing GitHub users, I used two fragments names UsersFragment and UserDetailFragment to rendering the user list and the detail of user. Both of them include a SwipeRefreshLayout to fetch and refresh the data. Also, UsersFragment includes a RecyclerView to render data efficiently. This application is constructed by following the Model-View-Presenter (MVP) design pattern. The project is organized by 

		com.example.alvinchang.shopbackexercise
			model
				User
				UserDetail
			ui
				view
					UserAdapter
					UserDetailFragment
					UsersFragment
					UsersHolder
				DisplayInterface
				GlideCircleTransform
			Presenter
			MainActivity

	In addition, to prevent reinventing the Wheel and speed up the developing process, I used Retrofit and Glide to fetch restful data and load the image efficiently.

	The user scenario is described as follow:
		1. Application user opens this application
		2. The application loads GitHub users automatically
		3. Application user click one of the GitHub users on the RecyclerView
		4. Another fragment is shown and displays the detail of selected GitHub user.
		5. To browse more detail, the application user can click the blog hyperlink, and the application will pop up a browser shows the website of GitHub user.

- what did you find most difficult
	The most difficult part is to design the architecture of the application. You have to spend a lot of time to design a best one. However, after that, all of the things can be done as expected.

- any other comments you would like to tell us
	This is a good exercise for warm up the Android skill.