package com.sma.delivery.service.ingredients;

import com.sma.delivery.beans.ingredients.IngredientsB;
import com.sma.delivery.dto.ingredients.IngredientDTO;
import com.sma.delivery.dto.ingredients.IngredientResult;
import com.sma.delivery.rest.ingredients.IIngredientsResource;
import com.sma.delivery.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("ingredientsService")
public class IngredientsServiceImpl extends BaseServiceImpl<IngredientsB, IngredientDTO> implements IIngredientsService {

    @Autowired
    private IIngredientsResource _ingredientsResource;


    public IngredientsServiceImpl() {
    }

    @Override
    @CachePut(value="delivery-cacheC", key= "'commentsClients_'+#ingredients.id", condition = "#bean.id!=null")
    public IngredientsB save(IngredientsB bean)  {
        final IngredientDTO comments = convertBeanToDto(bean);
        final IngredientDTO dto = _ingredientsResource.save(comments);

        final IngredientsB commentsB = convertDtoToBean(dto);
        if (bean.getId() == null) {
            getCacheManager().getCache("delivery-cacheC").put("ingredientsClients_" + dto.getId(), commentsB);
        }
        return commentsB;
    }

    @Override
    @CacheEvict(value = "delivery-cacheC", key = "'ingredientsClients_' + #id")
    public void delete(Integer id){
        _ingredientsResource.delete(id);
    }

    @Override
    public List<IngredientsB> getAll(Integer page)  {
        final IngredientResult result = _ingredientsResource.getAll(page);
        final List<IngredientDTO> cList = null == result.getIngredients() ? new ArrayList<IngredientDTO>()
                : result.getIngredients();

        final List<IngredientsB> comments = new ArrayList<IngredientsB>();
        for (IngredientDTO dto : cList) {
            final IngredientsB bean = convertDtoToBean(dto);
            comments.add(bean);
            if (bean.getId() != null) {
                getCacheManager().getCache("delivery-cacheC").put("ingredientsClients_" + dto.getId(), bean);
            }
        }
        return comments;
    }

    @Override
    @Cacheable(value= "delivery-cacheC", key= "'ingredientsClients_'+#id")
    public IngredientsB getById(Integer id)  {
        final IngredientDTO dto = _ingredientsResource.getById(id);
        final IngredientsB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    public List<IngredientsB> find(String text, Integer page)  {

        final IngredientResult result = _ingredientsResource.find(text, page);
        final List<IngredientDTO> cList = null == result.getIngredients() ? new ArrayList<IngredientDTO>()
                : result.getIngredients();

        final List<IngredientsB> comments = new ArrayList<IngredientsB>();
        for (IngredientDTO dto : cList) {
            final IngredientsB bean = convertDtoToBean(dto);
            comments.add(bean);
            if (bean.getId() != null) {
                getCacheManager().getCache("delivery-cacheC").put("ingredientsClients_" + dto.getId(), bean);
            }
        }
        return comments;
    }

    @Override
    protected IngredientsB convertDtoToBean(IngredientDTO dto)  {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("description", dto.getDescription());

        final IngredientsB commentsB = new IngredientsB(params);

        return commentsB;
    }

    @Override
        protected IngredientDTO convertBeanToDto(IngredientsB bean) {
            final IngredientDTO dto = new IngredientDTO();
            dto.setId(bean.getId());
            dto.setDescription(bean.getDescription());

        return dto;
    }

    @Override
    public List<IngredientsB> getIngredients()  {
        final IngredientResult result = _ingredientsResource.getIngredients();
        final List<IngredientDTO> cList = null == result.getIngredients() ? new ArrayList<IngredientDTO>() : result.getIngredients();
        final List<IngredientsB> comments = new ArrayList<IngredientsB>();
        for (IngredientDTO dto : cList) {
            comments.add(convertDtoToBean(dto));
        }
        return comments;
    }
}

