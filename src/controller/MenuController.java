package controller;

import java.util.List;
import model.*;
import view.*;

public class MenuController extends Controller{

	private MenuView view;
	private User model;
	private List<Product> productList;
	private List<Category> categoryList;
	
	public MenuController(MenuView view, User model, List<Product> productList, List<Category> categoryList) {
		this.view = view;
		this.model = model;
		this.productList = productList;
		this.categoryList = categoryList;
	}
	
	public void loadView() {
		clearView();
		view.printView(model.isAdmin());
		if(model.isAdmin()) {
			switch(view.getSelectOption()) {
			
				case "1":
					clearView();
					NewProductController product = new NewProductController(new NewProductView(), productList);
					product.loadView();
					loadView();
					break; 
					
				case "2":
					clearView();
					NewCategoryController category = new NewCategoryController(new NewCategoryView(), categoryList);
					category.loadView();
					loadView();
					break;
					
				case "3":
					clearView();
					System.out.println("Goodbye!");
					break;
					
				default:
					loadView();
					break;
			}
		}else{
			switch(view.getSelectOption()) {
			
				case "1":
					clearView();
					ShowProductController productListView = new ShowProductController(new ShowProductView(), productList, model);
					productListView.loadProductListView();
					loadView();
					break; 
					
				case "2":
					clearView();
					ShowProductController productsFromCategoryView = new ShowProductController(new ShowProductView(), productList, model);
					productsFromCategoryView.loadProductsFromCategory();
					loadView();
					break;
					
				case "3":
					clearView();
					ProfileController profile = new ProfileController(new ProfileView(), model);
					profile.loadView();
					loadView();
					break;
					
				case "4":
					clearView();
					break;
				
				default:
					clearView();
					System.out.println("User input error");
					loadView();
					break;
			}
		}
		
	}

}
