package com.sma.delivery.service.ingredientsProducts;

import com.sma.delivery.beans.ingredientsProducts.IngredientsProductsB;
import com.sma.delivery.dto.ingredients_products.IngredientsProductsDTO;
import com.sma.delivery.dto.ingredients_products.IngredientsProductsResult;
import com.sma.delivery.rest.ingredientsProducts.IIngredientsProductsResource;
import com.sma.delivery.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("ingredientsProductsService")
public class IngredientsProductsServiceImpl extends BaseServiceImpl<IngredientsProductsB, IngredientsProductsDTO> implements IIngredientsProductsService {

    @Autowired
    private IIngredientsProductsResource _ingredientsProductsResource;


    public IngredientsProductsServiceImpl() {
    }

    @Override
    public IngredientsProductsB save(IngredientsProductsB bean)  {
        final IngredientsProductsDTO comments = convertBeanToDto(bean);
        final IngredientsProductsDTO dto = _ingredientsProductsResource.save(comments);

        final IngredientsProductsB ingredientsProductsB = convertDtoToBean(dto);
        return ingredientsProductsB;
    }

    @Override
    public void delete(Integer id){
        _ingredientsProductsResource.delete(id);
    }

    @Override
    public List<IngredientsProductsB> getAll(Integer page)  {
        final IngredientsProductsResult result = _ingredientsProductsResource.getAll(page);
        final List<IngredientsProductsDTO> cList = null == result.getIngredientsProducts() ? new ArrayList<IngredientsProductsDTO>()
                : result.getIngredientsProducts();

        final List<IngredientsProductsB> comments = new ArrayList<>();
        for (IngredientsProductsDTO dto : cList) {
            final IngredientsProductsB bean = convertDtoToBean(dto);
            comments.add(bean);
        }
        return comments;
    }

    @Override
    public IngredientsProductsB getById(Integer id)  {
        final IngredientsProductsDTO dto = _ingredientsProductsResource.getById(id);
        final IngredientsProductsB bean = convertDtoToBean(dto);
        return bean;
    }

    @Override
    public List<IngredientsProductsB> find(String text, Integer page)  {

        final IngredientsProductsResult result = _ingredientsProductsResource.find(text, page);
        final List<IngredientsProductsDTO> cList = null == result.getIngredientsProducts() ? new ArrayList<>()
                : result.getIngredientsProducts();

        final List<IngredientsProductsB> comments = new ArrayList<>();
        for (IngredientsProductsDTO dto : cList) {
            final IngredientsProductsB bean = convertDtoToBean(dto);
            comments.add(bean);
        }
        return comments;
    }

    @Override
    protected IngredientsProductsB convertDtoToBean(IngredientsProductsDTO dto)  {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("product", String.valueOf(dto.getProduct()));
        params.put("ingredient", String.valueOf(dto.getIngredient()));

        final IngredientsProductsB commentsB = new IngredientsProductsB(params);

        return commentsB;
    }

    @Override
    protected IngredientsProductsDTO convertBeanToDto(IngredientsProductsB bean) {
        final IngredientsProductsDTO dto = new IngredientsProductsDTO();
        dto.setId(bean.getId());
        dto.setProduct(bean.getProduct());
        dto.setIngredient(bean.getIngredient());
        return dto;
    }

    @Override
    public List<IngredientsProductsB> getIngredientsProducts()  {
        final IngredientsProductsResult result = _ingredientsProductsResource.getIngredientsProducts();
        final List<IngredientsProductsDTO> cList = null == result.getIngredientsProducts() ? new ArrayList<>() : result.getIngredientsProducts();
        final List<IngredientsProductsB> ingredientsProducts = new ArrayList<>();
        for (IngredientsProductsDTO dto : cList) {
            ingredientsProducts.add(convertDtoToBean(dto));
        }
        return ingredientsProducts;
    }
}