
import re
import spacy



def extractdata(paragraph):
    pattern = r'^[\w\.-]+@[\w\.-]+\.\w+$'
    nlp1 = spacy.load('api\dataExtraction_model')
    doc = nlp1(paragraph)

    post = "" 
    postType = "" 
    companyName = "" 
    skill = "" 
    experience = "" 
    place = "" 
    email=  "" 
    for token in doc:

        if re.match(pattern, str(token))  :
            email += token.text + ","
        elif token.ent_type_=="POST":
            post += token.text + ","  
        elif token.ent_type_ =="POST-TYPE":
            postType += token.text +","    
        elif token.ent_type_ =="COMPANY_NAME":
            companyName = token.text    
        elif token.ent_type_ =="SKILLS":
            skill += token.text +","  
        elif token.ent_type_ =="EXPERIENCE" :
            experience += token.text + ","  
        elif token.ent_type_ =="PLACE":
            place += token.text +","  
    
    offre = {"post": post, "postType": postType,"companyName":companyName , "skill":skill ,"experience":experience , "place": place, "email":email }
    return offre 

