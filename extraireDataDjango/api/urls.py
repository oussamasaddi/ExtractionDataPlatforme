from django.urls import path 
from . import OffreController 


urlpatterns = [
    path("extraireOffre", OffreController.extraireData)
]
