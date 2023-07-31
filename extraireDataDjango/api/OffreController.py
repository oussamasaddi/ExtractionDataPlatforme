from rest_framework.response import Response 
from rest_framework.decorators import api_view
from . import OffreService





@api_view(['POST'])
def extraireData (Request):
    return Response(OffreService.extractdata(Request.data["paragraph"]))