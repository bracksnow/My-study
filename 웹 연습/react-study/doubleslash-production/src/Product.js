import React from 'react'

const Product = ({name,img,ingredient }) =>{
    return(
        <>
        <div className="product">
            <div className="Product__Columns">
                <h1>{name}</h1>   
            </div>
            <div className="Product__Columns">
                <div><ProductPicture img = {img} alt = {name}></ProductPicture></div>   
                <div className="Production__ingredients">
                    {ingredient.map((ingredient,i)=>{
                        return <ProductIngredient ingredient = {ingredient} ket = {ingredient+i}></ProductIngredient>
                    })}
                </div>
            </div>
        </div>
    </>
    );
}

const ProductPicture = ({img, alt}) =>{
    return(
        <>
            <img className='Production__img' src = {img} alt={alt}></img>
        </>
    );
}
const ProductIngredient = ({ingredient}) =>{
    return(
        <>
            <span className='Production__ingredients'>{ingredient}</span>
        </>
    );
}


export default Product;
